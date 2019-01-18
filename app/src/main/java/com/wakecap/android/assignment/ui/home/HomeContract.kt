package com.wakecap.android.assignment.ui.home

import androidx.annotation.StringRes
import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.ui.base.BaseContract

class HomeContract {

    interface View: BaseContract.View {

        fun initViews()
        fun openJavaFragment()
        fun openKotlinFragment()
    }

    interface Presenter : BaseContract.Presenter<HomeContract.View> {
        fun onJavaCardClicked()
        fun onKotlinCardClicked()
    }

}