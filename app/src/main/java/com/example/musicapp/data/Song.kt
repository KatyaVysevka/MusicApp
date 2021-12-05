package com.example.musicapp.data

import com.squareup.moshi.Json

data class Song(
    @Json(name = "title") var title : String,
    @Json(name = "artist") var artist : String,
    @Json(name = "bitmapUri") var bitmapUri : String,
    @Json(name = "trackUri") var trackUri : String,
    //@field:Json(name = "duration") var duration : Int
)
