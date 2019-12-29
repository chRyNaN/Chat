package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID
import com.chrynan.chat.model.ReactionCount

data class MessageReactionItemViewModel(
    override val messageID: ID,
    val reactions: List<ReactionCount>,
    val myReactions: List<ReactionCount>
) : MessageListItemViewModel