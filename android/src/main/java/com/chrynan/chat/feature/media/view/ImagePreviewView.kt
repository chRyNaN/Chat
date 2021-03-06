package com.chrynan.chat.feature.media.view

import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.view.View

interface ImagePreviewView : View {

    fun showImage(uri: UriString, key: String?)
}