package com.example.musicapp.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MusicDatabase (val readText: String) {
    suspend fun getAllSongs(): List<Song> {

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, Song::class.java)
        val adapter = moshi.adapter<List<Song>>(type)
        val list = mutableListOf<Song>()
        adapter.fromJson(
            readText
        )?.let{list.addAll(it)}

        return list
    }
}