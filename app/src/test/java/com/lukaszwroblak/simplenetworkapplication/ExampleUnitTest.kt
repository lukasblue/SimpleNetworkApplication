package com.lukaszwroblak.simplenetworkapplication

import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.model.ListView
import com.lukaszwroblak.simplenetworkapplication.presenter.ListPresenter
import com.lukaszwroblak.simplenetworkapplication.repository.ElementRepository
import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun listViewTestSuccess() {
        val listViewMock = ListViewMock()
        val listPresenter = ListPresenter(ElementRepositoryMock())
        listPresenter.setListView(listViewMock)
        listPresenter.getElementList()

        assertEquals(true, listViewMock.showProgressViewCalled)
        assertEquals(true, listViewMock.hideProgressViewCalled)
        assertEquals(true, listViewMock.showResultsCalled)
        assertEquals(false, listViewMock.showDetailsCalled)
        assertEquals(false, listViewMock.showNoResultsCalled)
        assertEquals(false, listViewMock.showNoInternetConnectionCalled)
        assertEquals(false, listViewMock.showErrorCalled)
    }

    @Test
    fun listViewTestFailCompleted() {
        val listViewMock = ListViewMock()
        val listPresenter = ListPresenter(ElementRepositoryMockFailCompoleted())
        listPresenter.setListView(listViewMock)
        listPresenter.getElementList()

        assertEquals(true, listViewMock.showProgressViewCalled)
        assertEquals(true, listViewMock.hideProgressViewCalled)
        assertEquals(false, listViewMock.showResultsCalled)
        assertEquals(false, listViewMock.showDetailsCalled)
        assertEquals(false, listViewMock.showNoResultsCalled)
        assertEquals(false, listViewMock.showNoInternetConnectionCalled)
        assertEquals(false, listViewMock.showErrorCalled)
    }


    @Test
    fun listViewTestFailError() {
        val listViewMock = ListViewMock()
        val listPresenter = ListPresenter(ElementRepositoryMockFailError())
        listPresenter.setListView(listViewMock)
        listPresenter.getElementList()

        assertEquals(true, listViewMock.showProgressViewCalled)
        assertEquals(true, listViewMock.hideProgressViewCalled)
        assertEquals(false, listViewMock.showResultsCalled)
        assertEquals(false, listViewMock.showDetailsCalled)
        assertEquals(false, listViewMock.showNoResultsCalled)
        assertEquals(false, listViewMock.showNoInternetConnectionCalled)
        assertEquals(true, listViewMock.showErrorCalled)
    }

    class ListViewMock: ListView {
        var showProgressViewCalled = false
        var hideProgressViewCalled = false
        var showResultsCalled = false
        var showDetailsCalled = false
        var showNoResultsCalled = false
        var showNoInternetConnectionCalled = false
        var showErrorCalled = false

        override fun showProgressView() {
            showProgressViewCalled = true
        }

        override fun hideProgressView() {
            hideProgressViewCalled = true
        }

        override fun showResults(elements: List<ElementBase>) {
            showResultsCalled = true
        }

        override fun showDetails(element: ElementBase) {
            showDetailsCalled = true
        }

        override fun showNoResults() {
            showNoResultsCalled = true
        }

        override fun showNoInternetConnection() {
            showNoInternetConnectionCalled = true
        }

        override fun showError(error: String) {
            showErrorCalled = true
        }

    }

    class ElementRepositoryMock : ElementRepository() {
        override fun getElements(): Observable<List<ElementBase>> {
            return Observable.create {
                observer ->
                var result = ArrayList<ElementBase>()
                result.add(ElementBase("name", "image"))
                observer.onNext(result)
                observer.onComplete()
            }
        }
    }

    class ElementRepositoryMockFailCompoleted : ElementRepository() {
        override fun getElements(): Observable<List<ElementBase>> {
            return Observable.create {
                observer ->
                observer.onComplete()
            }
        }
    }

    class ElementRepositoryMockFailError : ElementRepository() {
        override fun getElements(): Observable<List<ElementBase>> {
            return Observable.create {
                observer ->
                observer.onError(Throwable("error123"))
            }
        }
    }

}


