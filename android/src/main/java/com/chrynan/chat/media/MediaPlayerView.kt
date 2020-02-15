package com.chrynan.chat.media

import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.view.View
import com.google.android.exoplayer2.Player

interface MediaPlayerView : View {

    fun attachPlayer(player: Player)

    fun detachPlayer()

    fun showThumbnail(thumbnailUri: UriString?)

    fun showVideo()
}