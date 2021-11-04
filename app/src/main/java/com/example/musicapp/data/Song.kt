package com.example.musicapp.data

import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("title") var title : String,
    @SerializedName("artist") var artist : String,
    @SerializedName("bitmapUri") var bitmapUri : String,
    @SerializedName("trackUri") var trackUri : String,
    @SerializedName("duration") var duration : Int

)
