package com.wakecap.android.assignment.di.component

import com.wakecap.android.assignment.di.module.FragmentModule
import com.wakecap.android.assignment.ui.kotlinList.KotlinFragment
import com.wakecap.android.assignment.ui.home.HomeFragment
import dagger.Component

/**
 * Created by Amin on 16/01/2019.
 */
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun injectHome(homeFragment: HomeFragment)
    fun injectKotlinFragment(homeFragment: KotlinFragment)

}