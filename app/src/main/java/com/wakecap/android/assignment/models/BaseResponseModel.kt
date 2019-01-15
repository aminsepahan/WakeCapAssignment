package com.wakecap.android.assignment.models

data class BaseResponseModel<T>(val message: String, val data: BaseDataModel<T>)