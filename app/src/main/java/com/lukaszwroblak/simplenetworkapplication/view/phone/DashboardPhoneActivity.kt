package com.lukaszwroblak.simplenetworkapplication.view.phone

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.lukaszwroblak.simplenetworkapplication.R
import com.lukaszwroblak.simplenetworkapplication.utils.addFragment
import com.lukaszwroblak.simplenetworkapplication.utils.replaceFragment
import com.lukaszwroblak.simplenetworkapplication.view.DashboardInterface
import com.lukaszwroblak.simplenetworkapplication.view.DetailsFragment
import com.lukaszwroblak.simplenetworkapplication.view.ListFragment

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class DashboardPhoneActivity : AppCompatActivity(), DashboardInterface {

    private val fragmentList = ListFragment()
    private val fragmentDetails = DetailsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_phone)
        addFragment(fragmentList, R.id.flList)
    }

    override fun showDetails(elementName: String)  {
        fragmentDetails.currentName = elementName
        replaceFragment(fragmentDetails, R.id.flList)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun goBackToList() {
        replaceFragment(fragmentList, R.id.flList)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            goBackToList()
        }
        return super.onOptionsItemSelected(item)
    }

    //QUICK FIX I've missed the point about orientation change on tablet, I probably should solve this in more suffisticated way
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        finish()
    }
}