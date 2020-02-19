package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageHeaderDateItemViewModel(
    override val messageID: ID,
    val date: String
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$date".asUniqueAdapterId()
}