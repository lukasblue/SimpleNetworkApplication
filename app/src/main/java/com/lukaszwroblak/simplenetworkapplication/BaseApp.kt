package com.lukaszwroblak.simplenetworkapplication

import android.app.Application
import com.lukaszwroblak.simplenetworkapplication.di.component.ApplicationComponent
import com.lukaszwroblak.simplenetworkapplication.di.component.DaggerApplicationComponent

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerApplicationComponent.create().inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}
