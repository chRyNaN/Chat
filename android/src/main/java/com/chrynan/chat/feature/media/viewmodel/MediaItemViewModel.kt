package com.chrynan.chat.feature.media.viewmodel

import com.chrynan.chat.feature.reaction.model.core.UriString
import com.chrynan.chat.viewmodel.ViewModel

data class MediaItemViewModel(
    val uri: UriString,
    val key: String? = null // TODO consider how you pass around the key
) : ViewModel