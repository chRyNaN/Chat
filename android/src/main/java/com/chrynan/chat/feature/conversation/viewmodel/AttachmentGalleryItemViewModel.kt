package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.core.UriString

data class AttachmentGalleryItemViewModel(
    val uri: UriString,
    val videoLengthLabel: String? = null
) : AdapterItem {

    override val uniqueAdapterId = uri.asUniqueAdapterId()
}