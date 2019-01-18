package com.wakecap.android.assignment.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.wakecap.android.assignment.R

/**
 * Created by Amin on 08/06/2018.
 *
 */
fun androidx.fragment.app.Fragment.snack(
    message: String, buttonTxt: Int = R.string.ok,
    action: View.OnClickListener? = null, indefinite: Boolean = false
) {
    if (activity != null) {
        val snackBar: Snackbar = if (indefinite) {
            com.google.android.material.snackbar.Snackbar.make(activity!!.window.decorView.rootView, message, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE)
        } else {
            com.google.android.material.snackbar.Snackbar.make(activity!!.window.decorView.rootView, message, com.google.android.material.snackbar.Snackbar.LENGTH_LONG)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            snackBar.setAction(buttonTxt, action)
                .setActionTextColor(resources.getColor(R.color.md_yellow_200, activity!!.theme))
        } else {
            @Suppress("DEPRECATION")
            snackBar.setAction(buttonTxt, action).setActionTextColor(resources.getColor(R.color.md_yellow_200))
        }
        snackBar.show()
    }
}

fun View.showHideFade(showOrHide: Boolean) {
    val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
    if (showOrHide && visibility == VISIBLE && alpha == 1f) return
    if (!showOrHide && visibility == GONE && alpha == 0f) return
    animate().setDuration(shortAnimTime)
        .alpha((if (showOrHide) 1 else 0).toFloat())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = if (showOrHide) VISIBLE else GONE
            }

            override fun onAnimationStart(animation: Animator?) {
                visibility = VISIBLE
            }
        })
}