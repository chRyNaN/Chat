package com.chrynan.chat.media

import android.util.Log
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.decrypted.DecryptedAttachment
import com.google.android.exoplayer2.Player

class MediaPlayerViewQueueController @Inject constructor(
    private val controller: MediaController,
    private val mediaSourceCreator: MediaSourceCreator
) : MediaPlayerViewController,
    Player.EventListener {

    init {
        controller.player.addListener(this)
    }

    private val viewMap = mutableMapOf<MediaPlayerView, DecryptedAttachment.Video>()
    private val queue = mutableSetOf<MediaPlayerView>()

    private var currentView: MediaPlayerView? = null

    override fun bindOrEnter(view: MediaPlayerView, video: DecryptedAttachment.Video) {
        Log.w("TEST", "bindOrEnter: view = $view; video = $video")

        viewMap[view] = video

        if (currentView == null) {
            Log.w("TEST", "bindOrEnter: currentView == null")
            currentView = view
            view.showVideo()
            view.playVideo(video)
        } else {
            Log.w("TEST", "bindOrEnter: currentView != null")
            queue.add(view)
            view.showThumbnail(video.thumbnail)
        }
    }

    override fun exit(view: MediaPlayerView) {
        Log.w("TEST", "exit: view = $view")
        view.detachPlayer()
        queue.remove(view)

        if (view == currentView) {
            Log.w("TEST", "exit: view == currentView")
            controller.pause()
            playNextInQueue()
        }
    }

    override fun detach() {
        Log.w("TEST", "detach")

        queue.clear()
        viewMap.clear()
        currentView?.detachPlayer()
        currentView = null
        controller.release()
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)

        if (playbackState == Player.STATE_ENDED) {
            controller.pause()
            playNextInQueue()
        }
    }

    private fun playNextInQueue() {
        Log.w("TEST", "playNextInQueue")

        val nextView = queue.firstOrNull()
        queue.remove(nextView)

        val current = currentView
        val currentVideo = viewMap[current]
        currentView?.showThumbnail(currentVideo?.thumbnail)
        currentView = nextView

        nextView?.showVideo()
        val nextVideo = viewMap[nextView]
        nextView?.playVideo(nextVideo)
    }

    private fun MediaPlayerView.playVideo(video: DecryptedAttachment.Video?) {
        Log.w("TEST", "playVideo: view = $this; video = $video")
        if (video != null) {
            val source = mediaSourceCreator.fromUri(video.uri)
            attachPlayer(controller.player)
            controller.load(source)
            controller.mute()
            controller.resume()
        }
    }
}