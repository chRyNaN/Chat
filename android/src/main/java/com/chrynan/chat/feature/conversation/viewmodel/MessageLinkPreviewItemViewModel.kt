package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.UriString

data class MessageLinkPreviewItemViewModel(
    override val messageID: ID,
    val link: UriString,
    val title: String,
    val description: String? = null,
    val imageUri: UriString? = null
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$link".asUniqueAdapterId()
}