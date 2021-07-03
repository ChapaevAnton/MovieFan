package com.W4ereT1ckRtB1tch.moviefan.ui.home

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.W4ereT1ckRtB1tch.moviefan.R
import com.W4ereT1ckRtB1tch.moviefan.data.Film
import com.W4ereT1ckRtB1tch.moviefan.ui.home.CatalogFilmAdapter.ItemFilmHolder

class CatalogFilmAdapter(private val onItemClickListener: OnItemFilmClickListener) :
    RecyclerView.Adapter<ItemFilmHolder>() {

    private val itemsFilm = mutableListOf<Film>()

    fun addItems(itemsFilm: List<Film>) {
        this.itemsFilm.clear()
        this.itemsFilm.addAll(itemsFilm)
        notifyDataSetChanged()
    }


    interface OnItemFilmClickListener {
        fun onClickItem(film: Film)
    }

    inner class ItemFilmHolder(itemFilm: View) : RecyclerView.ViewHolder(itemFilm) {

        private val title: TextView = itemFilm.findViewById(R.id.title_film)
        private val poster: ImageView = itemFilm.findViewById(R.id.poster_film)
        private val rating: TextView = itemFilm.findViewById(R.id.rating_film)
        private val description: TextView = itemFilm.findViewById(R.id.description_film)
        private val year: TextView = itemFilm.findViewById(R.id.year_film)


        @RequiresApi(Build.VERSION_CODES.O)
        fun onBindItemFilm(film: Film) {

            title.text = film.title
            poster.setImageResource(film.poster)
            rating.text = film.rating.toString()
            description.text = film.description
            year.text = film.year.year.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFilmHolder {
        return ItemFilmHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ItemFilmHolder, position: Int) {
        holder.onBindItemFilm(itemsFilm[position])
        holder.itemView.setOnClickListener { onItemClickListener.onClickItem(itemsFilm[position]) }
    }

    override fun getItemCount(): Int {
        return itemsFilm.size
    }

}