package com.lukaszwroblak.simplenetworkapplication.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lukaszwroblak.simplenetworkapplication.R
import com.lukaszwroblak.simplenetworkapplication.datamodel.ElementDetails
import com.lukaszwroblak.simplenetworkapplication.di.component.DaggerFragmentComponent
import com.lukaszwroblak.simplenetworkapplication.model.DetailView
import com.lukaszwroblak.simplenetworkapplication.presenter.DetailPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
class DetailsFragment : Fragment(), DetailView {

    @Inject lateinit var presenter : DetailPresenter
    var currentName : String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFragmentComponent.create().inject(this)

        presenter.setDetailView(this)

        if(currentName!=null) {
            setElement(currentName!!)
        }
    }

    companion object {
        fun newInstance(name: String) : DetailsFragment {
            val args = Bundle()
            args.putString("name", name)
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }


    //-----   model implementations   --------------------------------------------------
    override fun showProgressView() {

    }

    override fun hideProgressView() {

    }

    override fun setElement(name: String) {
        presenter.getElementDetails(name)
    }

    override fun showResult(element: ElementDetails) {
        Picasso.with(context)
                .load(element.image)
                .into(ivImage)
        tvName.text = element.name
        tvText.text = element.text
    }


    override fun showNoResults() {

    }

    override fun showNoInternetConnection() {

    }

    override fun showError(error: String) {

    }
}