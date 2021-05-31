package com.mattdane.itunescatalogkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mattdane.itunescatalogkotlin.databinding.ActivityHomeBinding
import com.mattdane.itunescatalogkotlin.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private var _binding : ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
               supportFragmentManager.beginTransaction().apply {
                   replace(binding.framgenContainer.id, ArtistDetailsFragment())
                           .commit()
               }
        }
    }
}