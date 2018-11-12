package com.lukaszwroblak.simplenetworkapplication.model

import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
interface DetailView {
    fun showProgressView()
    fun hideProgressView()
    fun setElement(name: String)
    fun showResult(element : ElementDetails)
    fun showNoResults()
    fun showNoInternetConnection()
    fun showError(error: String)
}