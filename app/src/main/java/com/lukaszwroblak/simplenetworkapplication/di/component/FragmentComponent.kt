package com.lukaszwroblak.simplenetworkapplication.di.component

import com.lukaszwroblak.simplenetworkapplication.di.module.FragmentModule
import com.lukaszwroblak.simplenetworkapplication.view.DetailsFragment
import com.lukaszwroblak.simplenetworkapplication.view.ListFragment
import dagger.Component


/**
 * Created by lukaszwroblak on 11.11.2018.
 */
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)

    fun inject(detailsFragment: DetailsFragment)

}