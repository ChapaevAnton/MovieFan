package com.W4ereT1ckRtB1tch.moviefan.ui.selections

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

class SelectionsFragment : Fragment() {

    private lateinit var selectionCatalogFilmAdapter: SelectionCatalogFilmAdapter
    private lateinit var selectionRecyclerCatalogFilm: RecyclerView
    private lateinit var itemDecorator: SpacingItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectionCatalogFilmAdapter = SelectionCatalogFilmAdapter { film ->
            (requireActivity() as MainActivity).launchFilmDetailsFragment(film)
        }
        selectionCatalogFilmAdapter.addItems(DataBase.filmDataBase)

        itemDecorator = SpacingItemDecoration(10)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selections, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectionRecyclerCatalogFilm = view.findViewById(R.id.selections_recycler_catalog_film)

        selectionRecyclerCatalogFilm.apply {
            adapter = selectionCatalogFilmAdapter
            addItemDecoration(itemDecorator)
        }
    }


    override fun onResume() {
        super.onResume()
        selectionCatalogFilmAdapter.updateItems(DataBase.filmDataBase)
    }

}