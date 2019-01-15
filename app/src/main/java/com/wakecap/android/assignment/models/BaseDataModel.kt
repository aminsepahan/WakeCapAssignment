package com.wakecap.android.assignment.models

data class BaseDataModel<T>(val items: List<BaseItem<T>>, val meta: MetaModel)
