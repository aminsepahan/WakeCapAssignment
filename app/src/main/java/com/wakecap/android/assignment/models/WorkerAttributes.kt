package com.wakecap.android.assignment.models

import com.google.gson.annotations.SerializedName

data class WorkerAttributes(
    @SerializedName("helmet_color") val helmetColor: String,
    @SerializedName("site_id") val siteId: String,
    @SerializedName("role_id") val roleId: String,
    val id: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("worker_tag_id") val workerTagId: String,
    @SerializedName("contractor") val contractor: String,
    @SerializedName("mobile_number") val mobileNumber: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("Inventories") val Inventories: List<BaseItem<InventoryAttributes>>,
    val Role: BaseItem<RoleAttributes>,
    @SerializedName("role")val roleName: String
)
