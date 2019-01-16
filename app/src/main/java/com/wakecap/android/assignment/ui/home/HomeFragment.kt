package com.wakecap.android.assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.utils.BaseFragment


class HomeFragment : BaseFragment(), HomeContract.View {

    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun initViews() {

    }

    override fun showLoading(position: Int, showHide: Boolean) {

    }

    override fun workersListDataReady(position: Int, items: List<BaseItem<WorkerAttributes>>) {

    }

    override fun dataError(error: String) {

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
