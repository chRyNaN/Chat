package com.chrynan.chat.feature.media.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.media.binder.ImagePreviewBinder
import com.chrynan.chat.feature.media.viewmodel.ImagePreviewItemViewModel
import com.chrynan.chat.presenter.BasePresenter
import kotlinx.coroutines.launch

class ImagePreviewPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val binder: ImagePreviewBinder
) : BasePresenter(dispatchers) {

    fun setup(model: ImagePreviewItemViewModel) {
        launch {
            binder.bind(model)
        }
    }
}