package com.wakecap.android.assignment.ui.home

import android.support.annotation.StringRes
import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.ui.base.BaseContract

class HomeContract {

    interface View: BaseContract.View {

        fun isOnline(): Boolean
        fun initViews()
        fun openJavaFragment()
        fun openKotlinFragment()
        fun showLoading(position: Int, showHide: Boolean)
        fun workersListDataReady(
            position: Int,
            items: List<BaseItem<WorkerAttributes>>
        )

        fun dataError(error: String)
    }

    interface Presenter : BaseContract.Presenter<HomeContract.View> {
        fun onJavaCardClicked()
        fun onKotlinCardClicked()
    }

}