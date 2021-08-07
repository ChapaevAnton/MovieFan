package com.W4ereT1ckRtB1tch.moviefan.ui.custom.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.W4ereT1ckRtB1tch.moviefan.R

class RatingRoundView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) :
    View(context, attributeSet) {

    private val oval = RectF()

    private var centerX = 0f
    private var centerY = 0f
    private var radius = 0f
    private val scaleSize = 60f

    private var stroke = 10f
    private var progress = 50

    private var background = Color.DKGRAY //цвет фона
    private var ratingShadow = Color.DKGRAY //цвет тени рейтинга


    private lateinit var backgroundPaint: Paint //краска для фона
    private lateinit var ratingPaint: Paint //краска для рейтинга
    private lateinit var roundPaint: Paint //краска для кольца прогресса

    init {
        val attr =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.RatingRoundView, 0, 0)

        initPaint()
    }


    private fun initPaint() {

        backgroundPaint = Paint().apply {
            style = Paint.Style.FILL
            color = background
            isAntiAlias = true
        }


        ratingPaint = Paint().apply {

            style = Paint.Style.FILL_AND_STROKE
            setShadowLayer(5f, 0f, 0f, ratingShadow)
            strokeWidth = 2f
            textSize = scaleSize
            typeface = Typeface.SANS_SERIF
            color = getColorPaint(progress)
            isAntiAlias = true
        }

        roundPaint = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = stroke
            color = getColorPaint(progress)
            isAntiAlias = true
        }


    }

    private fun getColorPaint(progress: Int) = when (progress) {
        in 0..25 -> Color.parseColor("#e84258")
        in 26..50 -> Color.parseColor("#fd8060")
        in 51..75 -> Color.parseColor("#fee191")
        else -> Color.parseColor("#b0d8a4")
    }
}