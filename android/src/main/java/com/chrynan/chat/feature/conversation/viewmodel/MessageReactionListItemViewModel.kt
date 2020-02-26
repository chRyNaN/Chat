package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.model.Reaction
import com.chrynan.chat.model.core.ID

data class MessageReactionListItemViewModel(
    override val messageID: ID,
    val reaction: Reaction,
    val emoji: Emoji,
    val count: Int,
    val userSelected: Boolean
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID;$reaction;$count;$userSelected".asUniqueAdapterId()
}