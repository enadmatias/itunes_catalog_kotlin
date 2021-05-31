package com.mattdane.itunescatalogkotlin.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

object SearchResponse{

    data class Result(
    var results: ArrayList<ArtistModel>)


}