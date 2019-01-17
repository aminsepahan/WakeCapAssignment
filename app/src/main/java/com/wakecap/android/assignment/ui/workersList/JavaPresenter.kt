package com.wakecap.android.assignment.ui.workersList

import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.api.WebServices
import com.wakecap.android.assignment.api.WebServicesVolley
import com.wakecap.android.assignment.models.BaseResponseModel
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.utils.Constants.BASE_URL
import com.wakecap.android.assignment.utils.Constants.WORKERS_URL
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JavaPresenter : JavaContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: WebServices = WebServices.create()
    private lateinit var view: JavaContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: JavaContract.View) {
        this.view = view
        view.initViews()
    }

    override fun downloadDataFromApi(){

        //region checking if the device is online
        if (!view.isOnline()){
            view.showLoading(false)
            view.dataError(view.getStringFromRes(R.string.you_are_offline))
            return
        }
        //endregion

        //region Retrofit and Rxjava logic
        val subscribe = api.getWorkersList().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ model: BaseResponseModel<WorkerAttributes>? ->
                view.showLoading(false)
                if (model != null && model.data.items.isNotEmpty()) {
                    view.workersListDataReady(model.data.items)
                }
            },{ error ->
                view.showLoading(false)
                view.dataError(error.localizedMessage)
            })
        subscriptions.add(subscribe)
        //endregion

        //region Volley request which is commented and is not being used

//        WebServicesVolley().getRequest(BASE_URL + WORKERS_URL, object : WebServicesVolley.NetworkListeners {
//            override fun onResponse(response: String) {
//
//            }
//
//            override fun onError(message: String) {
//
//            }
//
//        }, view)

        //endregion
    }
}