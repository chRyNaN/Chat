package com.chrynan.chat.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.model.UriString
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import kotlinx.android.synthetic.main.widget_media_item.view.*

class MediaItemWidget @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    CardView(context, attrs) {

    private val player = SimpleExoPlayer.Builder(context).build()

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_media_item, this)

        mediaItemPlayerView?.player = player
    }

    fun loadImage(uri: UriString) {
        mediaItemImageView?.visibility = View.VISIBLE
        mediaItemPlayerView?.visibility = View.GONE
        mediaItemImageView?.load(uri)
    }

    fun loadVideo(source: MediaSource) {
        mediaItemPlayerView?.visibility = View.VISIBLE
        mediaItemImageView?.visibility = View.GONE
        player.prepare(source)
        player.playWhenReady = true
    }

    fun loadAudio(source: MediaSource) {
        mediaItemPlayerView?.visibility = View.VISIBLE
        mediaItemImageView?.visibility = View.GONE
        player.prepare(source)
    }

    fun loadFile(uri: UriString) {
        // TODO
    }

    fun resume() {
        if (mediaItemPlayerView?.visibility == View.VISIBLE) {
            player.playWhenReady = true
        }
    }

    fun pause() {
        player.playWhenReady = false
    }

    fun release() {
        player.release()
    }
}