package com.wakecap.android.assignment.models

import com.wakecap.android.assignment.ui.kotlinList.ListItem

data class BaseItem<T>(val type: String, val id: Int, val attributes: T): ListItem() {

    override fun getType(): Int {
        if (type == "workerrole"){
            return ROLE
        } else if (type == "worker"){
            return WORKER
        } else if (type == "inventory"){
            return INVENTORY
        } else {
            return 0
        }
    }

}