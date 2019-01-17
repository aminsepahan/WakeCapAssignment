package com.wakecap.android.assignment.ui.main

import com.wakecap.android.assignment.ui.base.BaseContract

class MainContract {

    interface View {

        fun showHomeFragment()
        fun showJavaListFragment()
        fun showKotlinFragment()
        fun onBackPressed()
    }

    interface Presenter : BaseContract.Presenter<MainContract.View> {
        fun onJavaCardClicked()
        fun onKotlinCardClicked()
    }

}