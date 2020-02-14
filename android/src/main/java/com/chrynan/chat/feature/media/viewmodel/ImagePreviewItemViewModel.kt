package com.chrynan.chat.feature.media.viewmodel

import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.viewmodel.ViewModel

data class ImagePreviewItemViewModel(
    val imageUri: UriString,
    val key: String? = null // TODO consider how you pass around the key
) : ViewModel