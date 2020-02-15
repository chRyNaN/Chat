package com.chrynan.chat.feature.media.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.feature.media.view.VideoPreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import javax.inject.Inject

class VideoPreviewBinder @Inject constructor(override val view: VideoPreviewView) :
    Binder<VideoPreviewView, MediaItemViewModel> {

    override suspend fun bind(viewModel: MediaItemViewModel) {
    }
}