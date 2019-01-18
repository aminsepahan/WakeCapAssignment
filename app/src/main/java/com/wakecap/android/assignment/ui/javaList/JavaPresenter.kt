package com.wakecap.android.assignment.ui.javaList

import android.annotation.SuppressLint
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.api.WebServices
import com.wakecap.android.assignment.models.BaseResponseModel
import com.wakecap.android.assignment.models.WorkerAttributes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class JavaPresenter : JavaContract.Presenter {

    private val api: WebServices = WebServices.create()
    private lateinit var view: JavaContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
    }

    override fun attach(view: JavaContract.View) {
        this.view = view
        view.initViews()
    }

    @SuppressLint("CheckResult")
    override fun downloadDataFromApi(){

        //region checking if the device is online
        if (!view.isOnline()){
            view.showLoading(false)
            view.dataError(view.getStringFromRes(R.string.you_are_offline))
            return
        }
        view.showLoading(true)
        //endregion

        //region Retrofit and Rxjava logic
        WebServices.create().getWorkersList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ model: BaseResponseModel<WorkerAttributes>? ->
                view.showLoading(false)
                if (model != null && model.data.items.isNotEmpty()) {
                    view.workersListDataReady(model.data.items)
                }
            },{ error ->
                view.showLoading(false)
                view.dataError(error.localizedMessage)
            })
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