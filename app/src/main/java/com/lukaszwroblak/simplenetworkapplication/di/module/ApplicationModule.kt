package com.lukaszwroblak.simplenetworkapplication.di.module

import android.app.Application
import com.lukaszwroblak.simplenetworkapplication.BaseApp
import com.lukaszwroblak.simplenetworkapplication.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}