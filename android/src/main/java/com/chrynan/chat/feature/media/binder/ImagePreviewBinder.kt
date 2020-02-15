package com.chrynan.chat.feature.media.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.feature.media.view.ImagePreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import javax.inject.Inject

class ImagePreviewBinder @Inject constructor(override val view: ImagePreviewView) :
    Binder<ImagePreviewView, MediaItemViewModel> {

    override suspend fun bind(viewModel: MediaItemViewModel) {
        view.showImage(uri = viewModel.uri, key = viewModel.key)
    }
}