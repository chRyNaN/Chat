package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageGroupHeaderItemViewModel(
    override val messageID: ID,
    val title: String
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID;$title".asUniqueAdapterId()
}