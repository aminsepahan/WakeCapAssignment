package com.wakecap.android.assignment.api

import android.util.Log
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.ui.base.BaseContract
import com.wakecap.android.assignment.ui.home.HomeContract
import com.wakecap.android.assignment.utils.App
import com.wakecap.android.assignment.utils.Constants.AUTH
import com.wakecap.android.assignment.utils.Constants.BASE_URL
import com.wakecap.android.assignment.utils.Constants.LOG_TAG
import com.wakecap.android.assignment.utils.Constants.VOLLEY_TIME_OUT
import com.wakecap.android.assignment.utils.Constants.WORKERS_URL
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class WebServicesVolley {

    fun getRequest(
        url: String,
        listener: NetworkListeners,
        view: HomeContract.View
    ): StringRequest {

        Log.d(LOG_TAG, " url = $url")
        val stringRequest = object : StringRequest(
            Request.Method.GET,
            BASE_URL + WORKERS_URL, Response.Listener<String> { response ->
                Log.d(LOG_TAG, " response for url $url ===== $response")
                listener.onResponse(response)
            },
            Response.ErrorListener { error ->
                parseError(error, url, listener, view)
            }) {
//            override fun getBodyContentType(): String {
//                return "application/json; charset=utf-8"
//            }

            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = AUTH
                headers["Content-Type"] = "application/json"
                headers["X-Requested-With"] = "XMLHttpRequest"

                return headers
            }
        }

        stringRequest.retryPolicy = DefaultRetryPolicy(
            VOLLEY_TIME_OUT,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )

        App.app.addToRequestQueue(stringRequest)
        return stringRequest

    }



    private fun parseError(error: VolleyError, url: String, listener: NetworkListeners, view: BaseContract.View) {
        var message = ""
        if (error.networkResponse != null) {
            if (error.networkResponse.data != null) {
                message = String(error.networkResponse.data)
                var jsonObject: JSONObject? = null
                try {
                    jsonObject = JSONObject(message)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                if (jsonObject != null && jsonObject.has("message")) {
                    try {
                        message = jsonObject.getString("message")
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }
            }
            message += error.networkResponse.statusCode
            if (message.contains("html")) {
                Log.d(LOG_TAG, " error for url $url == $message")
                message = view.getStringFromRes(R.string.connection_error)
            }
        } else {
            message = view.getStringFromRes(R.string.connection_error)
        }
        Log.d(LOG_TAG, " error for url $url == $message")
        listener.onError(message)
    }

    interface NetworkListeners {
        fun onResponse(response: String)
        fun onError(message: String)
    }
}

