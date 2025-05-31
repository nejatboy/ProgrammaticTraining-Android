package com.example.programmatictraining.ui.movie

import androidx.annotation.DrawableRes


data class Movie(
    val name: String,
    @DrawableRes val imageId: Int,
    val description: String
)
