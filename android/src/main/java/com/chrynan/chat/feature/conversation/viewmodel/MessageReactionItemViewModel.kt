package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.ReactionCount
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageReactionItemViewModel(
    override val messageID: ID,
    val reactions: List<ReactionCount>,
    val myReactions: List<ReactionCount>
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$reactions$myReactions".asUniqueAdapterId()
}