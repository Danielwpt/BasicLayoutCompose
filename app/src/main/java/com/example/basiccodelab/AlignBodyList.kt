package com.example.basiccodelab

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AlignBodyList(
    @DrawableRes val image : Int,
    @StringRes val text : Int
)
