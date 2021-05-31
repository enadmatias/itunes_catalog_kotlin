package com.mattdane.itunescatalogkotlin.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mattdane.itunescatalogkotlin.di.DaggerApiComponent
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel: ViewModel() {

    private val disposable = CompositeDisposable()

    val itunes = MutableLiveData<SearchResponse.Result>()


    @Inject
    lateinit var itunesservice : ItunesService
    init{
       DaggerApiComponent.create().inject(this)
    }


    public fun searchArtist(name:String, media: String, country: String) {
          disposable.add(
                 itunesservice.searchArtist(name, media,country)
                         .subscribeOn(Schedulers.newThread())
                         .observeOn(AndroidSchedulers.mainThread())
                         .subscribeWith(object : DisposableSingleObserver<SearchResponse.Result>(){
                             override fun onSuccess(value: SearchResponse.Result) {
                                 itunes.value = value
                             }

                             override fun onError(e: Throwable?) {
                                 Log.d("error", e.toString())
                             }
                         })



          )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}