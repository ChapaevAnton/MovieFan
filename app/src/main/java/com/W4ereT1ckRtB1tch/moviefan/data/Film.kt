package com.W4ereT1ckRtB1tch.moviefan.data

import android.os.Parcelable
import java.time.LocalDate
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val poster: Int,
    val description: String,
    val rating: Float,
    val year:LocalDate
):Parcelable