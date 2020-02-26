package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.core.ID

data class MessageTextItemViewModel(
    override val messageID: ID,
    val text: String
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$text".asUniqueAdapterId()
}