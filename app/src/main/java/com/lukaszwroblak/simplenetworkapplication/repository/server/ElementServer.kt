package com.lukaszwroblak.simplenetworkapplication.repository.server

import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails
import com.lukaszwroblak.simplenetworkapplication.repository.NetApi
import com.lukaszwroblak.simplenetworkapplication.repository.api
import io.reactivex.Observable

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class ElementServer {

    fun getElements() : Observable<List<ElementBase>> {
        return api<NetApi>().getList()
    }

    fun getElementDetails(elementName: String): Observable<ElementDetails> {
        return api<NetApi>().getDetails(elementName)
    }
}