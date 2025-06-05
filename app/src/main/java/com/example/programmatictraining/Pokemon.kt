package com.example.programmatictraining

import androidx.annotation.DrawableRes


data class Pokemon(
    val name: String,
    @DrawableRes val imageId: Int
)
