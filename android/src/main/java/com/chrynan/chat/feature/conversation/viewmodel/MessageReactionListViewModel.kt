package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.core.ID

data class MessageReactionListViewModel(
    override val messageID: ID,
    val reactions: List<MessageReactionListItemViewModel>
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$reactions".asUniqueAdapterId()
}