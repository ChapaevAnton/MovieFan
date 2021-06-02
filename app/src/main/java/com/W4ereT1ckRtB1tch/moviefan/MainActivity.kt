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

        val coordinatorSnackBar = findViewById<CoordinatorLayout>(R.id.coordinator_snack_bar_main)

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

                else -> false
            }
        }

    }


    private fun showSnackBar(view: View, text: Int) {


        val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
        val coordinatorView = snackBar.view
        val paramsView:CoordinatorLayout.LayoutParams = coordinatorView.layoutParams as CoordinatorLayout.LayoutParams
        paramsView.gravity = Gravity.TOP
        coordinatorView.layoutParams = paramsView
        snackBar.setBackgroundTint(ContextCompat.getColor(view.context, R.color.ivi_blue)).show()

    }

}