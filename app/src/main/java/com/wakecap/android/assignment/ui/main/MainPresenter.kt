package com.wakecap.android.assignment.ui.main

import io.reactivex.disposables.CompositeDisposable
/**
 * Created by Amin on 16/01/2019.
 */
class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View


    override fun onJavaCardClicked() {
        view.showJavaListFragment()
    }

    override fun onKotlinCardClicked() {
        view.showKotlinFragment()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showHomeFragment() // as default
    }

}