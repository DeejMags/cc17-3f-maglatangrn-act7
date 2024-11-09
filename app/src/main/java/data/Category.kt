package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val name: Int,
    @DrawableRes val picture: Int,
    val reccomendationList: List<Reccomendation>
)