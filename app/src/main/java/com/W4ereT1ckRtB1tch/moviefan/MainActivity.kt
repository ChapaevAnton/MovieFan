package com.W4ereT1ckRtB1tch.moviefan

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //верхнее меню
        val mainMenuTopBar = findViewById<MaterialToolbar>(R.id.main_menu_top_bar)
        //нижнее меню
        val menuMainNavigationBottom =
            findViewById<BottomNavigationView>(R.id.menu_main_navigation_bottom_bar)

        //обработчик выбора пунктов меню Top Bar
        mainMenuTopBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.main_menu_setting -> {
                    showSnackBar(R.string.main_menu_settings)
                    true
                }
                else -> false
            }
        }

        //обработчик выбора пунктов меню Navigation Bottom
        menuMainNavigationBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main_menu_home -> {
                    showSnackBar(R.string.main_menu_home)
                    true
                }

                R.id.main_menu_my_selections -> {
                    showSnackBar(R.string.main_menu_my_selections)
                    true
                }

                R.id.main_menu_favorites -> {
                    showSnackBar(R.string.main_menu_favorites)
                    true
                }

                R.id.main_menu_profile -> {
                    showSnackBar(R.string.main_menu_profile)
                    true
                }
                else -> false
            }
        }
    }

    //функция отображения snackbar с заданной позицией и цветом
    private fun showSnackBar(text: Int) {
        val viewSnackBar = findViewById<CoordinatorLayout>(R.id.frame_snack_bar_main)
        Snackbar.make(viewSnackBar, text, Snackbar.LENGTH_LONG).also {
            val view = it.view
            val paramsView: CoordinatorLayout.LayoutParams =
                view.layoutParams as CoordinatorLayout.LayoutParams
            paramsView.gravity = Gravity.BOTTOM
            view.layoutParams = paramsView
        }.setBackgroundTint(ContextCompat.getColor(viewSnackBar.context, R.color.ivi_blue)).show()
    }

}