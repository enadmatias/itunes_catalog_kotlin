package com.mattdane.itunescatalogkotlin.model

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {


    @GET("search")
    fun getArtistDetails(
        @Query("term") trackName: String?,
        @Query("media") media: String?,
        @Query("country") country: String?
    ): Single<SearchResponse.Result>
}