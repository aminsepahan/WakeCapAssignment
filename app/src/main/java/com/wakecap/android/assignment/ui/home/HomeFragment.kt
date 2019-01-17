package com.wakecap.android.assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.di.component.DaggerFragmentComponent
import com.wakecap.android.assignment.di.module.FragmentModule
import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.WorkerAttributes
import com.wakecap.android.assignment.utils.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun initViews() {
        javaCard.setOnClickListener { presenter.onJavaCardClicked() }
        kotlinCard.setOnClickListener { presenter.onKotlinCardClicked() }
    }

    override fun showLoading(position: Int, showHide: Boolean) {

    }

    override fun workersListDataReady(position: Int, items: List<BaseItem<WorkerAttributes>>) {

    }

    override fun dataError(error: String) {

    }

    @Suppress("DEPRECATION")
    private fun injectDependency() {
        val aboutComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        aboutComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
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
