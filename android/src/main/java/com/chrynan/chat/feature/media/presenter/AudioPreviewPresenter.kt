package com.chrynan.chat.feature.media.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.media.binder.AudioPreviewBinder
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.presenter.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class AudioPreviewPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val binder: AudioPreviewBinder
) : BasePresenter(dispatchers) {

    fun setup(model: MediaItemViewModel) {
        launch {
            binder.bind(model)
        }
    }
}