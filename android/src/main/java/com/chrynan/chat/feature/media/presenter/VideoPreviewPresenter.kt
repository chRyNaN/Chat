package com.chrynan.chat.feature.media.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.media.binder.VideoPreviewBinder
import com.chrynan.chat.feature.media.view.VideoPreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.media.MediaController
import com.chrynan.chat.media.MediaSourceCreator
import com.chrynan.chat.presenter.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoPreviewPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: VideoPreviewView,
    private val binder: VideoPreviewBinder,
    private val mediaController: MediaController,
    private val mediaSourceCreator: MediaSourceCreator
) : BasePresenter(dispatchers) {

    override fun onUnbind() {
        super.onUnbind()

        mediaController.pause()
        mediaController.release()
        view.detachPlayer()
    }

    fun setup(model: MediaItemViewModel) {
        launch {
            view.attachPlayer(mediaController.player)
            view.showVideo()
            mediaController.load(mediaSourceCreator.fromUri(model.uri))
            mediaController.resume()
            binder.bind(model)
        }
    }
}