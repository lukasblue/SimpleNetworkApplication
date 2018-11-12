package com.lukaszwroblak.simplenetworkapplication.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lukaszwroblak.simplenetworkapplication.R
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementBase
import com.lukaszwroblak.simplenetworkapplication.di.component.DaggerFragmentComponent
import com.lukaszwroblak.simplenetworkapplication.model.ListView
import com.lukaszwroblak.simplenetworkapplication.presenter.ListPresenter
import com.lukaszwroblak.simplenetworkapplication.view.adapter.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class ListFragment : Fragment(), ListView {

    private lateinit var adapter: ListAdapter
    @Inject lateinit var presenter: ListPresenter
//    private var presenter = ListPresenter(ElementRepository())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        DaggerFragmentComponent.create().inject(this)

        presenter.setListView(this)

        adapter = ListAdapter(this::showDetails)
        rvList.adapter = adapter

        presenter.getElementList()
    }


    //-----   model implementations   --------------------------------------------------
    override fun showProgressView() {

    }

    override fun hideProgressView() {

    }

    override fun showDetails(element: ElementBase) {
        (activity as DashboardInterface).showDetails(element.name)
    }

    override fun showResults(elements: List<ElementBase>) {
        adapter.items.clear()
        adapter.items.addAll(elements)
        adapter.notifyDataSetChanged()
    }

    override fun showNoResults() {

    }

    override fun showNoInternetConnection() {

    }

    override fun showError(error: String) {

    }


}