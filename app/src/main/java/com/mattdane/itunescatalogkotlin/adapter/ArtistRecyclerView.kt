package com.mattdane.itunescatalogkotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mattdane.itunescatalogkotlin.R
import com.mattdane.itunescatalogkotlin.databinding.AdapterArtistListBinding
import com.mattdane.itunescatalogkotlin.model.ArtistModel
import com.mattdane.itunescatalogkotlin.model.SearchResponse
import java.util.ArrayList

class ArtistRecyclerView(var artist: ArrayList<ArtistModel>, val context: Context, val callback: Callback):
    RecyclerView.Adapter<ArtistRecyclerView.ViewHolder>() {

    fun updateData(newArtist: ArrayList<ArtistModel>){
        artist.clear()
        artist.addAll(newArtist)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterArtistListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(artist[position]){
                   binding.trackTXT.text = trackName
                   binding.artistTXT.text = artistName
                   binding.genreTXT.text = primaryGenreName
                   binding.priceTXT.text = collectionPrice.toString()
                   Glide.with(context).load(artworkUrl100).error(R.drawable.ic_launcher_background).into(binding.artWorkIMG)
                   binding.artistV.setOnClickListener{
                       callback.onItemClick(artist[position])
                }
            }
        }
    }

    inner  class ViewHolder(val  binding: AdapterArtistListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return artist.size
    }

    interface Callback{
        fun onItemClick(model: ArtistModel)
    }
}