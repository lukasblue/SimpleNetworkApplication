package com.lukaszwroblak.simplenetworkapplication.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

}