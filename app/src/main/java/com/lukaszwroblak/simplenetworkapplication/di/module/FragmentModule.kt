package com.lukaszwroblak.simplenetworkapplication.di.module

import com.lukaszwroblak.simplenetworkapplication.presenter.DetailPresenter
import com.lukaszwroblak.simplenetworkapplication.presenter.ListPresenter
import com.lukaszwroblak.simplenetworkapplication.repository.ElementRepository
import dagger.Module
import dagger.Provides

/**
 * Created by lukaszwroblak on 11.11.2018.
 */
@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(elementRepository: ElementRepository): ListPresenter {
        return ListPresenter(elementRepository)
    }

    @Provides
    fun provideDetailPresenter(elementRepository: ElementRepository) : DetailPresenter {
        return DetailPresenter(elementRepository)
    }

    @Provides
    fun provideElementRepository(): ElementRepository {
        return ElementRepository()
    }
}