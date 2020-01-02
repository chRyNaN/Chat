package com.chrynan.chat.media

import com.chrynan.chat.model.UriString
import com.google.android.exoplayer2.source.MediaSource

interface MediaSourceCreator {

    fun fromUri(uri: UriString): MediaSource
}