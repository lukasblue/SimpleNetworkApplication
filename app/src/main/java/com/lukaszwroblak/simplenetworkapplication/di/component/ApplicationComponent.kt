package com.lukaszwroblak.simplenetworkapplication.di.component

import com.lukaszwroblak.simplenetworkapplication.BaseApp
import com.lukaszwroblak.simplenetworkapplication.di.module.ApplicationModule
import dagger.Component

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}