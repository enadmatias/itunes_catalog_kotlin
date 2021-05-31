package com.mattdane.itunescatalogkotlin.model


import com.mattdane.itunescatalogkotlin.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class ItunesService {
    @Inject
    lateinit var api: ItunesApi

   init {
      DaggerApiComponent.create().inject(this)
   }

   fun searchArtist(name: String?, media: String?, country: String?): Single<SearchResponse.Result>{
       return api.getArtistDetails(name,media,country)
   }


}