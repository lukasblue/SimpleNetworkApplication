package com.lukaszwroblak.simplenetworkapplication.presenter

import android.content.Context
import com.lukaszwroblak.simplenetworkapplication.model.DetailView
import com.lukaszwroblak.simplenetworkapplication.repository.ElementRepository
import com.lukaszwroblak.simplenetworkapplication.utils.checkInternetConnection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

class DetailPresenter(var elementRepository: ElementRepository, var context : Context? = null)  {

    private var detailView : DetailView? = null

    fun setDetailView(detailView: DetailView) {
        this.detailView = detailView
    }

    fun getElementDetails(elementName: String) {
        detailView?.showProgressView()

        if (context != null) {
            if(!checkInternetConnection(context!!)) {
                detailView?.showNoInternetConnection()
            }
        }

        elementRepository.getElementDetails(elementName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result ->
                    detailView?.hideProgressView()
                    detailView?.showResult(result)
                }, {
                    error ->
                    detailView?.hideProgressView()
                    detailView?.showError(error.localizedMessage)
                }, {
                    detailView?.hideProgressView()
                })
    }
}
