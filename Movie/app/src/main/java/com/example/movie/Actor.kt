package com.example.movie

import androidx.annotation.DrawableRes

data class Actor(
    val name: String,
    @DrawableRes val photoRes: Int
)
