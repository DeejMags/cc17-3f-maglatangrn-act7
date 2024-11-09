package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Reccomendation(
    @StringRes val title: Int,
    @StringRes val text: Int,
    @DrawableRes val image: Int
)