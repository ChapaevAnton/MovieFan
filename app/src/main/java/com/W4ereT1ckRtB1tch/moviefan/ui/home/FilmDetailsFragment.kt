package com.W4ereT1ckRtB1tch.moviefan.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.W4ereT1ckRtB1tch.moviefan.MainActivity
import com.W4ereT1ckRtB1tch.moviefan.R
import com.W4ereT1ckRtB1tch.moviefan.data.DataBase
import com.W4ereT1ckRtB1tch.moviefan.data.Film
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilmDetailsFragment : Fragment() {

    private lateinit var film: Film


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        film = arguments?.get(MainActivity.ITEM_FILM_DETAILS) as Film
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_film_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val detailsTitle: CollapsingToolbarLayout = view.findViewById(R.id.details_title_film)
        val detailsPoster: AppCompatImageView = view.findViewById(R.id.details_poster_film)
        val detailsDescription: TextView = view.findViewById(R.id.details_description_film)
        val detailsFavorite: FloatingActionButton = view.findViewById(R.id.details_favorites_film)

        film.apply {
            detailsTitle.title = title
            detailsPoster.setImageResource(poster)
            detailsDescription.text = description
            detailsFavorite.setImageResource(if (film.isFavorites) R.drawable.ic_round_favorite_24 else R.drawable.ic_round_favorite_border_24)
        }

        //добавить в избранное
        detailsFavorite.setOnClickListener {
            if (film.isFavorites) {
                film.isFavorites = false
                detailsFavorite.setImageResource(R.drawable.ic_round_favorite_border_24)
            } else {
                film.isFavorites = true
                detailsFavorite.setImageResource(R.drawable.ic_round_favorite_24)
            }
            Log.d("TAG", "DataBase: ${DataBase.filmDataBase}")
        }
    }
}