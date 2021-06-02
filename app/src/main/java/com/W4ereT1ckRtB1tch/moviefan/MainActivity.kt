package com.W4ereT1ckRtB1tch.moviefan

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //контейнер для snackbar
        val coordinatorSnackBar = findViewById<CoordinatorLayout>(R.id.coordinator_snack_bar_main)

        //обработчик выбора пунктов меню Navigation Bottom
        val menuMainNavigationBottom =
            findViewById<BottomNavigationView>(R.id.menu_main_navigation_bottom_bar)
        menuMainNavigationBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main_menu_home -> {
                    showSnackBar(coordinatorSnackBar, R.string.main_menu_home)
                    true
                }

                R.id.main_menu_my_selections -> {
                    showSnackBar(coordinatorSnackBar, R.string.main_menu_my_selections)
                    true
                }

                R.id.main_menu_favorites -> {
                    showSnackBar(coordinatorSnackBar, R.string.main_menu_favorites)
                    true
                }

                R.id.main_menu_profile -> {
                    showSnackBar(coordinatorSnackBar, R.string.main_menu_profile)
                    true
                }
                else -> false
            }
        }
    }

    //функция отображения snackbar с заданной позицией и цветом
    private fun showSnackBar(view: View, text: Int) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).also {
            val coordinatorView = it.view
            val paramsView: CoordinatorLayout.LayoutParams =
                coordinatorView.layoutParams as CoordinatorLayout.LayoutParams
            paramsView.gravity = Gravity.CENTER
            coordinatorView.layoutParams = paramsView
        }.setBackgroundTint(ContextCompat.getColor(view.context, R.color.ivi_blue)).show()
    }

}