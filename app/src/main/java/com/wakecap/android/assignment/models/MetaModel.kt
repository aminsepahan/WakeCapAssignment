package com.wakecap.android.assignment.models

import com.google.gson.annotations.SerializedName

data class MetaModel(
    val total: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int
)