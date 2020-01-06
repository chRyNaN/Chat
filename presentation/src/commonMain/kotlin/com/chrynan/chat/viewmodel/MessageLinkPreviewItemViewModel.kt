package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.UriString

data class MessageLinkPreviewItemViewModel(
    override val messageID: ID,
    val link: UriString,
    val title: String,
    val description: String? = null,
    val imageUri: UriString? = null
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$link".asUniqueAdapterId()
}