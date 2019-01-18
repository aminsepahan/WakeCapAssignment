package com.wakecap.android.assignment.ui.base

import androidx.annotation.StringRes

/**
 * Created by Amin on 16/01/2019.
 */
class BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
        fun getStringFromRes(@StringRes int: Int): String
    }
}