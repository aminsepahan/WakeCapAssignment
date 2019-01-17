package com.wakecap.android.assignment.ui.home

import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.api.WebServices
import com.wakecap.android.assignment.api.WebServicesVolley
import com.wakecap.android.assignment.models.BaseResponseModel
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.utils.Constants.BASE_URL
import com.wakecap.android.assignment.utils.Constants.WORKERS_URL
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter : HomeContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: WebServices = WebServices.create()
    private lateinit var view: HomeContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
        view.initViews()
    }

    override fun onJavaCardClicked() {
        downloadDataFromApi(0)
    }

    override fun onKotlinCardClicked() {
        downloadDataFromApi(1)
    }

    private fun downloadDataFromApi(position: Int){

        if (!view.isOnline()){
            view.showLoading(position, false)
            view.dataError(view.getStringFromRes(R.string.you_are_offline))
            return
        }

        //region Retrofit and Rxjava logic which does not work with Wakecap API and gives 401
        val subscribe = api.getWorkersList().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ model: BaseResponseModel<WorkerAttributes>? ->
                view.showLoading(position, false)
                if (model != null && model.data.items.isNotEmpty()) {
                    view.workersListDataReady(position, model.data.items)
                }
            },{ error ->
                view.showLoading(position, false)
                view.dataError(error.localizedMessage)
            })
        subscriptions.add(subscribe)
        //endregion

        //region Volley request

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