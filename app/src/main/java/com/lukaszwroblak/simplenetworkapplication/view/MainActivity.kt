package com.lukaszwroblak.simplenetworkapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lukaszwroblak.simplenetworkapplication.R
import com.lukaszwroblak.simplenetworkapplication.utils.nav
import com.lukaszwroblak.simplenetworkapplication.view.phone.DashboardPhoneActivity
import com.lukaszwroblak.simplenetworkapplication.view.tablet.DashboardTabletActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isTablet: Boolean = resources.getBoolean(R.bool.isTablet);

        if (isTablet && resources.configuration.orientation == 2) {  //QUICK FIX I've missed the point about orientation change on tablet, I probably should solve this in more suffisticated way
            nav<DashboardTabletActivity>()
        } else {
            nav<DashboardPhoneActivity>()
        }
    }

}
