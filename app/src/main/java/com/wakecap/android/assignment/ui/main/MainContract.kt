package com.wakecap.android.assignment.ui.main

class MainContract {

    interface View {
        fun setListeners()
    }

    interface Presenter {
        fun onJavaCardClicked()
        fun onKotlinCardClicked()
    }

}