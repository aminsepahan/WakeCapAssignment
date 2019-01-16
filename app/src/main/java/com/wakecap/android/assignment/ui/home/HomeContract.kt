package com.wakecap.android.assignment.ui.home

import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.ui.base.BaseContract

class HomeContract {

    interface View {
        fun initViews()
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