package com.wakecap.android.assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.di.component.DaggerFragmentComponent
import com.wakecap.android.assignment.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : Fragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter
    private lateinit var rootView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun getStringFromRes(@StringRes int: Int): String {
        return getString(int)
    }

    @Suppress("DEPRECATION")
    private fun injectDependency() {
        val homeComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        homeComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
    }


    override fun openJavaFragment() {
        findNavController().navigate(R.id.javaFragment)
    }

    override fun openKotlinFragment() {
        findNavController().navigate(R.id.kotlinFragment)
    }



}
