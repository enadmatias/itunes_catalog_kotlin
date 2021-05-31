package com.mattdane.itunescatalogkotlin.di

import com.mattdane.itunescatalogkotlin.model.ItunesApi
import com.mattdane.itunescatalogkotlin.model.ItunesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://itunes.apple.com/"

    @Provides
    fun  provideCountriesApi(): ItunesApi{


        val client = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client.addInterceptor(logging).build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ItunesApi::class.java)
    }

    @Provides
    fun providesItunes(): ItunesService{
        return ItunesService()
    }



}