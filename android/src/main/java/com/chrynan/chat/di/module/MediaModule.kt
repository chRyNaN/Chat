package com.chrynan.chat.di.module

import com.chrynan.chat.media.*
import com.chrynan.chat.utils.ActivityContext
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MediaModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideSimpleExoPlayer(context: ActivityContext): SimpleExoPlayer =
            SimpleExoPlayer.Builder(context).build()
    }

    @Binds
    abstract fun bindListMediaPlayerViewController(controller: MediaPlayerViewQueueController): MediaPlayerViewController

    @Binds
    abstract fun bindMediaSourceCreator(creator: AndroidMediaSourceCreator): MediaSourceCreator

    @Binds
    abstract fun bindMediaController(controller: SimpleExoPlayerMediaController): MediaController
}