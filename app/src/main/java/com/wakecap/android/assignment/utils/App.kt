package com.wakecap.android.assignment.utils

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class App : Application() {

    private var mRequestQueue: RequestQueue? = null
        get() = if (field == null) {
            field = Volley.newRequestQueue(applicationContext)
            field
        } else field

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
        app = this
    }

    fun <T> addToRequestQueue(req: com.android.volley.Request<T>) {
        mRequestQueue?.add(req)
    }

    companion object {
        lateinit var prefs: Prefs
        lateinit var app: App
    }
}