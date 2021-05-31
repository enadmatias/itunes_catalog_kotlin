package com.mattdane.itunescatalogkotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.mattdane.itunescatalogkotlin.databinding.ActivityArtistDetailsBinding
import com.mattdane.itunescatalogkotlin.databinding.ActivityMainBinding

class ArtistDetailsActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding : ActivityArtistDetailsBinding? = null
    private val binding get() = _binding!!


    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArtistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name: String? = intent.getStringExtra("name")
        val preview: String? = intent.getStringExtra("video")
        val trackName: String? = intent.getStringExtra("trackName")
        val desc: String? = intent.getStringExtra("desc")

        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(this)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(binding.trailerVideo)
        }
        binding.trailerVideo.setMediaController(mediaControls)
        binding.trailerVideo.setVideoURI(Uri.parse(preview))
        binding.trailerVideo.seekTo( 1 );
        binding.trailerVideo.requestFocus()
        binding.trailerVideo.start()


        binding.artistNameTXT.text = name
        binding.titleTXT.text = trackName
        binding.descriptionTXT.text = desc

    }
}