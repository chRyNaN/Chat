package com.chrynan.chat.feature.media.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.feature.media.view.AudioPreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import javax.inject.Inject

class AudioPreviewBinder @Inject constructor(override val view: AudioPreviewView) :
    Binder<AudioPreviewView, MediaItemViewModel> {

    override suspend fun bind(viewModel: MediaItemViewModel) {
    }
}