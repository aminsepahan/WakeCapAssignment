package com.wakecap.android.assignment.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.di.component.DaggerActivityComponent
import com.wakecap.android.assignment.di.module.ActivityModule
import com.wakecap.android.assignment.ui.base.BaseContract
import com.wakecap.android.assignment.ui.home.HomeFragment
import com.wakecap.android.assignment.ui.workersList.JavaFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View, BaseContract.HomeFragmentOnCLickListener {


    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }


    override fun showHomeFragment() {
        replaceFragment(HomeFragment.newInstance())
    }

    override fun showJavaListFragment() {
        replaceFragment(JavaFragment.newInstance())
    }

    override fun showKotlinFragment() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    @Suppress("DEPRECATION")
    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onClicked(javaOrKotlin: Boolean) {

    }

    private fun replaceFragment(fragment: Fragment ) {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.frame, fragment)
            .commit()
    }
}
