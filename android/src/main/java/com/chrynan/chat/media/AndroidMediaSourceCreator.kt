package com.chrynan.chat.media

import android.net.Uri
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.UriString
import com.chrynan.chat.utils.ActivityContext
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class AndroidMediaSourceCreator @Inject constructor(context: ActivityContext) : MediaSourceCreator {

    private val dataSourceFactory: DataSource.Factory =
        DefaultDataSourceFactory(context, Util.getUserAgent(context, "Chat"))

    override fun fromUri(uri: UriString): MediaSource =
        ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(uri))
}