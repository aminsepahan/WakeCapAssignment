package com.wakecap.android.assignment.di.component

import com.wakecap.android.assignment.di.module.ApplicationModule
import com.wakecap.android.assignment.utils.App
import dagger.Component

/**
 * Created by Amin on 16/01/2019.
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: App)

}