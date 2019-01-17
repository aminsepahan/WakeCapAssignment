package com.wakecap.android.assignment.ui.home

import com.wakecap.android.assignment.api.WebServices
import com.wakecap.android.assignment.models.BaseResponseModel
import com.wakecap.android.assignment.models.WorkerAttributes
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
    }
}