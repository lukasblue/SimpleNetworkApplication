package com.lukaszwroblak.simplenetworkapplication.repository.storage


import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class ElementStorage {

    fun getElements() : Observable<List<ElementBase>> {
        return Observable.create{
            observer ->
            observer.onComplete()
        }
    }

    fun getElementDetails(elementName: String) : Observable<ElementDetails> {
        return Observable.create{
            observer ->
            observer.onComplete()
        }
    }

}