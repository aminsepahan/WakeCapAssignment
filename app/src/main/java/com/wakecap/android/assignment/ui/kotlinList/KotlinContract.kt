package com.wakecap.android.assignment.ui.kotlinList

import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.ui.base.BaseContract

class KotlinContract {
    interface View : BaseContract.View {

        fun initViews()
        fun isOnline(): Boolean
        fun showLoading(showHide: Boolean)
        fun workersListDataReady(
            items: List<ListItem>
        )

        fun dataError(error: String)
    }

    interface Presenter : BaseContract.Presenter<KotlinContract.View> {
        fun downloadDataFromApi()
    }
}