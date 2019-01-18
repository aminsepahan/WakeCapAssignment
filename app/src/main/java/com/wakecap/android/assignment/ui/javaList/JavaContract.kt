package com.wakecap.android.assignment.ui.javaList

import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.ui.base.BaseContract

class JavaContract {

    interface View: BaseContract.View {

        fun initViews()
        fun isOnline(): Boolean
        fun showLoading(showHide: Boolean)
        fun workersListDataReady(
            items: List<BaseItem<WorkerAttributes>>
        )
        fun dataError(error: String)
    }

    interface Presenter : BaseContract.Presenter<JavaContract.View> {
        fun downloadDataFromApi()
    }

}