package com.wakecap.android.assignment.utils

import android.content.Context
import android.content.SharedPreferences
import com.wakecap.android.assignment.utils.Constants.NULL

class Prefs(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME_BASE, 0)


    fun isSet(value: String): Boolean{
        return value != NULL
    }
}