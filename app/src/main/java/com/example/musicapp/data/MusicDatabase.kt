package com.example.musicapp.data

import android.content.Context
import com.example.musicapp.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@ServiceScoped
class MusicDatabase(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi,
    private val ioDispatcher: CoroutineDispatcher
) {

    @Inject constructor(
        @ApplicationContext context: Context, moshi: Moshi,
    ): this(context, moshi, Dispatchers.IO)

    private val playlistSongs: List<Song> by lazy {
        val playlistString = context.resources.openRawResource(R.raw.playlist).bufferedReader().use { input ->
            input.readText()
        }

        val type = Types.newParameterizedType(List::class.java, Song::class.java)
        val adapter = moshi.adapter<List<Song>>(type)

        adapter.fromJson(playlistString) ?: emptyList()
    }

    suspend fun getAllSongs(): List<Song> = withContext(ioDispatcher) {
        return@withContext playlistSongs
    }
}