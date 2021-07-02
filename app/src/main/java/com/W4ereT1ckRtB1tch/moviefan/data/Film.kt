package com.W4ereT1ckRtB1tch.moviefan.data

import java.time.LocalDate

data class Film(
    val title: String,
    val poster: Int,
    val description: String,
    val rating: Float,
    val year:LocalDate
)