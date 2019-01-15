package com.wakecap.android.assignment.models

import com.google.gson.annotations.SerializedName

data class InventoryAttributes(val type: String,
                               val name: String,
                               @SerializedName("site_id") val siteId: String,
                               @SerializedName("is_active") val isActive: Boolean,
                               @SerializedName("is_online") val isOnline: Boolean,
                               @SerializedName("maximum_voltage") val maximumVoltage: Int)
