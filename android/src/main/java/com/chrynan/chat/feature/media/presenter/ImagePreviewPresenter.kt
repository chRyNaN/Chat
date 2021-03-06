package com.chrynan.chat.feature.media.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.media.binder.ImagePreviewBinder
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.presenter.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImagePreviewPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val binder: ImagePreviewBinder
) : BasePresenter(dispatchers) {

    fun setup(model: MediaItemViewModel) {
        launch {
            binder.bind(model)
        }
    }
}