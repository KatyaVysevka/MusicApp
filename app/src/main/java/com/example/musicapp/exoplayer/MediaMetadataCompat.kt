package com.example.musicapp.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.example.musicapp.data.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            it.title.toString(),
            it.description.toString(),
            it.iconUri.toString(),
            it.mediaUri.toString(),
            it.describeContents()
        )
    }
}