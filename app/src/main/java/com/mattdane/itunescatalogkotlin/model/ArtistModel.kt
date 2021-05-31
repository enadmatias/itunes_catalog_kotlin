package com.mattdane.itunescatalogkotlin.model

import com.google.gson.annotations.SerializedName

data class ArtistModel(


    @SerializedName("wrapperType")
    var wrapperType: String? = null,
    @SerializedName("kind")
    var kind: String? = null,

    @SerializedName("trackId")
    var trackId: Int = 0,

    @SerializedName("artistName")
    var artistName: String? = null,

    @SerializedName("trackName")
    var trackName: String? = null,

    @SerializedName("trackCensoredName")
    var trackCensoredName: String? = null,

    @SerializedName("trackViewUrl")
    var trackViewUrl: String? = null,

    @SerializedName("previewUrl")
    var previewUrl: String? = null,

    @SerializedName("artworkUrl30")
    var artworkUrl30: String? = null,

    @SerializedName("artworkUrl60")
    var artworkUrl60: String? = null,

    @SerializedName("artworkUrl100")
    var artworkUrl100: String? = null,

    @SerializedName("collectionPrice")
    var collectionPrice: Double = 0.0,

    @SerializedName("trackPrice")
    var trackPrice:Double = 0.0,

    @SerializedName("trackRentalPrice")
    var trackRentalPrice:Double = 0.0,

    @SerializedName("collectionHdPrice")
    var collectionHdPrice:Double = 0.0,

    @SerializedName("trackHdPrice")
    var trackHdPrice:Double = 0.0,

    @SerializedName("trackHdRentalPrice")
    var trackHdRentalPrice: Double = 0.0,

    @SerializedName("releaseDate")
    var releaseDate: String? = null,

    @SerializedName("collectionExplicitness")
    var collectionExplicitness: String? = null,

    @SerializedName("trackExplicitness")
    var trackExplicitness: String? = null,

    @SerializedName("trackTimeMillis")
    var trackTimeMillis: Int = 0,

    @SerializedName("country")
    var country: String? = null,

    @SerializedName("currency")
    var currency: String? = null,

    @SerializedName("primaryGenreName")
    var primaryGenreName: String? = null,

    @SerializedName("contentAdvisoryRating")
    var contentAdvisoryRating: String? = null,

    @SerializedName("shortDescription")
    var shortDescription: String? = null,

    @SerializedName("longDescription")
    var longDescription: String? = null,

    @SerializedName("hasITunesExtras")
    var hasITunesExtras: Boolean = false
)