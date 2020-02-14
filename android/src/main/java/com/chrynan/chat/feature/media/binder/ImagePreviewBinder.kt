package com.chrynan.chat.feature.media.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.media.view.ImagePreviewView
import com.chrynan.chat.feature.media.viewmodel.ImagePreviewItemViewModel

class ImagePreviewBinder @Inject constructor(override val view: ImagePreviewView) :
    Binder<ImagePreviewView, ImagePreviewItemViewModel> {

    override suspend fun bind(viewModel: ImagePreviewItemViewModel) {
        view.showImage(uri = viewModel.imageUri, key = viewModel.key)
    }
}