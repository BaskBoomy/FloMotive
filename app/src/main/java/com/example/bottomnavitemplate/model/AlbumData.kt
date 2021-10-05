package com.example.bottomnavitemplate.model

import android.graphics.drawable.Drawable

data class AlbumData (
    val title: String,
            val artist: String,
                    val img: Int,
    val type: Int,
    val buttonTitle : String,
    val buttonColor : Drawable)
