package com.wakecap.android.assignment.di.module

import android.app.Application
import com.wakecap.android.assignment.di.scope.PerApplication
import com.wakecap.android.assignment.utils.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Amin on 16/01/2019.
 */
@Module
class ApplicationModule(private val baseApp: App) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}