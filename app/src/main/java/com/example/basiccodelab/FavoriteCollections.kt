package com.example.basiccodelab

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FavoriteCollections(
    @DrawableRes val image : Int,
    @StringRes val text : Int
)
