package com.wakecap.android.assignment.ui.kotlinList

abstract class ListItem {

    abstract fun getType(): Int

    companion object {
        const val WORKER = 1
        const val ROLE = 2
        const val INVENTORY = 3
    }
}