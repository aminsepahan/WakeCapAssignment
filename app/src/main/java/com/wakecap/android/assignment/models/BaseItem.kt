package com.wakecap.android.assignment.models

data class BaseItem<T>(val type: String, val id: Int, val attributes: T)