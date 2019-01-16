package com.wakecap.android.assignment.utils

import android.content.Context
import android.support.v4.app.Fragment
import com.wakecap.android.assignment.ui.main.MainContract

abstract class BaseFragment: Fragment() {

    protected var listener: MainContract.View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is MainContract.View) {
            listener = (activity as MainContract.View)
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    companion object {
        val TAG: String = "TAG"
    }
}