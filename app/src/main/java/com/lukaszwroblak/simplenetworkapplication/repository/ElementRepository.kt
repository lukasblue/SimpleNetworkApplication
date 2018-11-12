package com.lukaszwroblak.simplenetworkapplication.repository

import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails
import com.lukaszwroblak.simplenetworkapplication.repository.server.ElementServer
import com.lukaszwroblak.simplenetworkapplication.repository.storage.ElementStorage
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

open class ElementRepository {

    private val elementStorage = ElementStorage()
    private val elementServer = ElementServer()

    open fun getElements() : Observable<List<ElementBase>> {
        return Observable.create<List<ElementBase>> {  observer ->
            var done = false
            elementStorage.getElements().subscribe({
                resultDb ->
                done = true
                observer.onNext(resultDb)
                observer.onComplete()
            }, {
                error ->
            }, {
                if (!done) {
                    elementServer.getElements().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ resultNet ->
                        observer.onNext(resultNet)
                        observer.onComplete()
                    })
                }
            })
        }
    }

    fun getElementDetails(elementName: String) : Observable<ElementDetails> {
        return Observable.create<ElementDetails> { observer ->
            var done = false
            elementStorage.getElementDetails(elementName).subscribe({
                resultDb ->
                done = true
                observer.onNext(resultDb)
                observer.onComplete()
            }, {
                error ->
            }, {
                if(!done) {
                    elementServer.getElementDetails(elementName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                        resultNet ->
                        observer.onNext(resultNet)
                        observer.onComplete()
                    })
                }
            })

        }
    }
}