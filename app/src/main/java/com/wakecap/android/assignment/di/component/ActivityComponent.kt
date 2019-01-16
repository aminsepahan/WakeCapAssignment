package com.wakecap.android.assignment.di.component

import com.wakecap.android.assignment.di.module.ActivityModule
import com.wakecap.android.assignment.ui.main.MainActivity
import dagger.Component

/**
 * Created by Amin on 16/01/2019.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}