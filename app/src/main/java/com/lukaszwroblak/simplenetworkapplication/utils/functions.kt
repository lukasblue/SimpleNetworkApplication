package com.lukaszwroblak.simplenetworkapplication.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import java.io.Serializable

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

inline fun <reified T : Any> Context.nav() {
    val intent = Intent(this, T::class.java)

    startActivity(intent)
}

inline fun <reified T : Any> Context.nav(vararg params: Pair<String, Serializable>) {
    val intent = Intent(this, T::class.java)

    for (param in params) {
        intent.putExtra(param.first, param.second)
    }

    startActivity(intent)
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func().commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}

fun checkInternetConnection(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    return isConnected
}