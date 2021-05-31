package com.mattdane.itunescatalogkotlin.di

import com.mattdane.itunescatalogkotlin.model.ItunesService
import com.mattdane.itunescatalogkotlin.model.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {


    fun inject(service: ItunesService)
    fun inject(viewModel: ListViewModel)
}