package com.W4ereT1ckRtB1tch.moviefan.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.W4ereT1ckRtB1tch.moviefan.MainActivity
import com.W4ereT1ckRtB1tch.moviefan.R
import com.W4ereT1ckRtB1tch.moviefan.data.Film
import com.google.android.material.appbar.CollapsingToolbarLayout

class ItemFilmDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_film_details)

        val detailsTitle: CollapsingToolbarLayout = findViewById(R.id.details_title_film)
        val detailsPoster: AppCompatImageView = findViewById(R.id.details_poster_film)
        val detailsDescription: TextView = findViewById(R.id.details_description_film)

        val film: Film = intent.extras?.get(MainActivity.ITEM_FILM_DETAILS) as Film

        film.apply {
            detailsTitle.title = title
            detailsPoster.setImageResource(poster)
            detailsDescription.text = description
        }
    }


}