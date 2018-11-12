package com.lukaszwroblak.simplenetworkapplication.di.component

import com.lukaszwroblak.simplenetworkapplication.di.module.ActivityModule
import com.lukaszwroblak.simplenetworkapplication.view.MainActivity
import dagger.Component

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}