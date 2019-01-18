package com.wakecap.android.assignment.ui.kotlinList

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.florent37.viewanimator.ViewAnimator
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.utils.showHideFade
import kotlinx.android.synthetic.main.fragment_list.*


class KotlinFragment : Fragment(), KotlinContract.View {

    override fun isOnline(): Boolean {
        val cm =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    override fun showLoading(showHide: Boolean) {
        progress.showHideFade(showHide)
    }

    override fun workersListDataReady(items: List<ListItem>) {
        rv.adapter = KotlinListAdapter(items)
        ViewAnimator.animate(rv).slideBottomIn().duration(500).start()
    }

    override fun dataError(error: String) {

    }

    lateinit var presenter: KotlinContract.Presenter
    private lateinit var rootView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        rv.layoutManager = LinearLayoutManager(activity)
        return rootView
    }

    override fun initViews() {
    }

    override fun getStringFromRes(@StringRes int: Int): String {
        return getString(int)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = KotlinPresenter()
        presenter.attach(this)
        presenter.attach(this)
        presenter.subscribe()
    }


}
