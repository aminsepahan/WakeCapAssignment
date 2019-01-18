package com.wakecap.android.assignment.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.di.component.DaggerActivityComponent
import com.wakecap.android.assignment.di.module.ActivityModule
import com.wakecap.android.assignment.ui.base.BaseContract
import com.wakecap.android.assignment.ui.home.HomeFragment
import com.wakecap.android.assignment.ui.workersList.JavaFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {


    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)
    }


    @Suppress("DEPRECATION")
    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

}
