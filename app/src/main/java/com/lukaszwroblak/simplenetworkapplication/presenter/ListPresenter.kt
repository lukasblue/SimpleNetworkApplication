package com.lukaszwroblak.simplenetworkapplication.presenter

import android.content.Context
import com.lukaszwroblak.simplenetworkapplication.model.ListView
import com.lukaszwroblak.simplenetworkapplication.repository.ElementRepository
import com.lukaszwroblak.simplenetworkapplication.utils.checkInternetConnection

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

class ListPresenter(var elementRepository: ElementRepository, var context : Context? = null) {

    private var listView : ListView? = null

    fun setListView(listView: ListView) {
        this.listView = listView
    }

    fun getElementList() {
        listView?.showProgressView()

        if (context != null) {
            if (!checkInternetConnection(context!!)) {
                listView?.showNoInternetConnection()
            }
        }

        elementRepository.getElements()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    listView?.hideProgressView()
                    listView?.showResults(result)
                }, { error ->
                    listView?.hideProgressView()
                    listView?.showError(error.localizedMessage)
                }, {
                    listView?.hideProgressView()
                })
    }

}