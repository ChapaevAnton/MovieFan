package com.W4ereT1ckRtB1tch.moviefan.ui.home

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
import com.google.android.material.appbar.MaterialToolbar

class HomeFragment : Fragment() {

    private lateinit var catalogFilmAdapter: CatalogFilmAdapter
    private lateinit var mainRecyclerCatalogFilm: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //верхнее меню
        val mainMenuTopBar = view.findViewById<MaterialToolbar>(R.id.home_menu_top_bar)
        //список фильмов основной
        mainRecyclerCatalogFilm = view.findViewById(R.id.home_recycler_catalog_film)

        //иницилизирем список
        initRecyclerCatalogFilm()

        //обработчик выбора пунктов меню Top Bar
        mainMenuTopBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.main_menu_setting -> {
                    (requireActivity() as MainActivity).showSnackBar(R.string.main_menu_settings)
                    true
                }
                else -> false
            }
        }
    }

    //иницилизирем список
    private fun initRecyclerCatalogFilm() {
        //создаем адаптер клик на элементе
        catalogFilmAdapter =
            CatalogFilmAdapter { film ->
                //открываем фрагмент и передаем данные
                (requireActivity() as MainActivity).launchFilmDetailsFragment(film)
            }
        //загружаем БД
        catalogFilmAdapter.addItems(DataBase().filmDataBase)
        //декоратор
        val itemDecorator = SpacingItemDecoration(10)

        mainRecyclerCatalogFilm.apply {
            //устанавливаем адаптер
            adapter = catalogFilmAdapter
            addItemDecoration(itemDecorator)
        }
    }

}