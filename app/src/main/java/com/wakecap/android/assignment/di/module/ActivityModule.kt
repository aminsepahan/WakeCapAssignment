package com.wakecap.android.assignment.di.module

import android.app.Activity
import com.wakecap.android.assignment.ui.main.MainContract
import com.wakecap.android.assignment.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Amin on 16/01/2019.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}