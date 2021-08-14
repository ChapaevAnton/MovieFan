package com.W4ereT1ckRtB1tch.moviefan.ui.custom.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.W4ereT1ckRtB1tch.moviefan.R
import kotlin.math.min

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

        try {
            stroke = attr.getFloat(R.styleable.RatingRoundView_stroke_round, stroke)
            progress = attr.getInt(R.styleable.RatingRoundView_progress, progress)
        } finally {
            attr.recycle()
        }

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

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = min(width, height).div(2f)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val chooseWidth = getDimension(widthMode, widthSize)
        val chooseHeight = getDimension(heightMode, heightSize)
        val minSide = min(chooseWidth, chooseHeight)

        centerX = minSide.div(2f)
        centerY = minSide.div(2f)
        setMeasuredDimension(minSide, minSide)
    }

    override fun onDraw(canvas: Canvas?) {
        drawRound(canvas) //кольцо прогресса
    }

    private fun drawRound(canvas: Canvas?) {
        val scale = radius * 0.8f
        oval.set(0f - scale, 0f - scale, scale, scale)

        canvas?.let {
            it.save()
            it.translate(centerX, centerY)
            it.drawCircle(0f, 0f, radius, backgroundPaint)
            it.drawArc(oval, -90f, convertProgressToDegrees(progress), false, roundPaint)
            it.restore()
        }
    }

    private fun getColorPaint(progress: Int) = when (progress) {
        in 0..25 -> Color.parseColor("#e84258")
        in 26..50 -> Color.parseColor("#fd8060")
        in 51..75 -> Color.parseColor("#fee191")
        else -> Color.parseColor("#b0d8a4")
    }

    private fun getDimension(mode: Int, size: Int): Int {
        return when (mode) {
            MeasureSpec.AT_MOST, MeasureSpec.EXACTLY -> size
            else -> 300
        }
    }

    private fun convertProgressToDegrees(progress: Int): Float {
        return progress * 3.6f
    }
}