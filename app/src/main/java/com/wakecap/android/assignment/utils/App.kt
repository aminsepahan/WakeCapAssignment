package com.wakecap.android.assignment.utils

import android.app.Application

class App : Application() {

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()

    }

    companion object {
       lateinit var prefs: Prefs
    }
}