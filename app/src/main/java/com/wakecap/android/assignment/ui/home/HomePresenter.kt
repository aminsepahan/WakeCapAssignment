package com.wakecap.android.assignment.ui.home

import com.wakecap.android.assignment.api.WebServices
import io.reactivex.disposables.CompositeDisposable

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
        view.openJavaFragment()
    }

    override fun onKotlinCardClicked() {
        view.openKotlinFragment()
    }

}