package com.wakecap.android.assignment.ui.home

class HomeContract {

    interface View {

        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter {
        fun onJavaCardClicked()
        fun onKotlinCardClicked()
    }

}