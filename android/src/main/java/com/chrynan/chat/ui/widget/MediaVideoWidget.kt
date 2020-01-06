package com.chrynan.chat.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.media.MediaPlayerView
import com.chrynan.chat.model.core.UriString
import com.google.android.exoplayer2.Player
import kotlinx.android.synthetic.main.widget_video_item.view.*

class MediaVideoWidget @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    CardView(context, attrs),
    MediaPlayerView {

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_video_item, this)
    }

    override fun attachPlayer(player: Player) {
        videoItemPlayerView?.player = player
        requestLayout()
    }

    override fun detachPlayer() {
        videoItemPlayerView?.player = null
    }

    override fun showThumbnail(thumbnailUri: UriString?) {
        videoItemPlayerView?.visibility = View.GONE
        videoThumbnailImageView?.visibility = View.VISIBLE
        videoThumbnailImageView?.load(thumbnailUri)
    }

    override fun showVideo() {
        videoItemPlayerView?.visibility = View.VISIBLE
        videoThumbnailImageView?.visibility = View.GONE
    }
}