package com.W4ereT1ckRtB1tch.moviefan

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMenuHome = findViewById<Button>(R.id.main_menu_home)
        val buttonMenuFavorites = findViewById<Button>(R.id.main_menu_favorites)
        val buttonMenuWatchLater = findViewById<Button>(R.id.main_menu_watch_later)
        val buttonMenuMySelections = findViewById<Button>(R.id.main_menu_home_my_selections)
        val buttonMenuSettings = findViewById<Button>(R.id.main_menu_settings)


        buttonMenuHome.setOnClickListener {
            showSnackBar(it, R.string.main_menu_home)
        }

        buttonMenuFavorites.setOnClickListener {
            showSnackBar(it, R.string.main_menu_favorites)
        }

        buttonMenuWatchLater.setOnClickListener {
            showSnackBar(it, R.string.main_menu_watch_later)
        }

        buttonMenuMySelections.setOnClickListener {
            showSnackBar(it, R.string.main_menu_my_selections)
        }

        buttonMenuSettings.setOnClickListener {
            showSnackBar(it, R.string.main_menu_settings)
        }

    }

    private fun showSnackBar(view: View, text: Int) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).apply {
            setBackgroundTint(ContextCompat.getColor(context, R.color.ivi_blue))
        }.show()
    }

}