package com.W4ereT1ckRtB1tch.moviefan.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.W4ereT1ckRtB1tch.moviefan.MainActivity
import com.W4ereT1ckRtB1tch.moviefan.R
import com.W4ereT1ckRtB1tch.moviefan.data.DataBase
import com.W4ereT1ckRtB1tch.moviefan.ui.utils.SpacingItemDecoration

class FavoritesFragment : Fragment() {

    private lateinit var favoritesRecyclerCatalogFilm: RecyclerView
    private lateinit var favoritesCatalogFilmAdapter: FavoritesCatalogFilmAdapter
    private lateinit var itemDecorator: SpacingItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesCatalogFilmAdapter = FavoritesCatalogFilmAdapter { film ->
            (requireActivity() as MainActivity).launchFilmDetailsFragment(film)
        }
        favoritesCatalogFilmAdapter.addItems(DataBase.filmDataBase.filter { it.isFavorites })
        //декоратор
        itemDecorator = SpacingItemDecoration(10)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesRecyclerCatalogFilm = view.findViewById(R.id.favorites_recycler_catalog_film)

        //иницилизирем список
        favoritesRecyclerCatalogFilm.apply {
            //устанавливаем адаптер
            adapter = favoritesCatalogFilmAdapter
            addItemDecoration(itemDecorator)
        }
    }

}