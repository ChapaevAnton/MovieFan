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



    }


    private fun showSnackBar(view: View, text: Int) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).apply {
            setBackgroundTint(ContextCompat.getColor(context, R.color.ivi_blue))
        }.show()
    }

}