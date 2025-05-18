package com.example.movie

import androidx.annotation.DrawableRes

data class Movie(
    val title: String,
    val age: String,
    val genre: String,
    val reviews: Int,
    val duration: Int,
    @DrawableRes val posterRes: Int,
    @DrawableRes val bannerRes: Int  // нов поле
)
