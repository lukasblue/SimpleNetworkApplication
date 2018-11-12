package com.lukaszwroblak.simplenetworkapplication.model

import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
interface ListView {
    fun showProgressView()
    fun hideProgressView()
    fun showResults(elements : List<ElementBase>)
    fun showDetails(element: ElementBase)
    fun showNoResults()
    fun showNoInternetConnection()
    fun showError(error: String)
}