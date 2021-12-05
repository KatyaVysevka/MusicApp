package com.example.musicapp.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.musicapp.R
import com.example.musicapp.exoplayer.MusicServiceConnection
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMusicServiceConnection (
        @ApplicationContext context: Context
    ) = MusicServiceConnection(context)


    // There is a way to set default RequestOptions
    // for instance of GLide retrieved from `Glide.with(...)` methods.
    // Please, read more about it here:
    // http://bumptech.github.io/glide/doc/configuration.html#default-request-options
    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_baseline_music_note_24)
            .error(R.drawable.ic_baseline_music_note_24)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

    @Singleton
    @Provides
    fun provideDefaultMoshi() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}