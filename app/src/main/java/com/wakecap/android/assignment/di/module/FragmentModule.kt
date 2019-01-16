package com.wakecap.android.assignment.di.module


import com.wakecap.android.assignment.api.WebServices
import com.wakecap.android.assignment.ui.home.HomeContract
import com.wakecap.android.assignment.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Amin on 16/01/2019.
 */
@Module
class FragmentModule {


    @Provides
    fun providesHomePresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

    @Provides
    fun provideApiService(): WebServices {
        return WebServices.create()
    }
}