package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.ReactionCount
import com.chrynan.chat.feature.reaction.model.core.UriString
import com.chrynan.chat.resources.ResourceID

data class MessageActionItemViewModel(
    override val messageID: ID,
    val messageCount: String?,
    val lastReplyDate: String?,
    val replyUserImageUris: List<UriString> = emptyList(),
    val status: String? = null,
    val statusImageResourceID: ResourceID,
    val reactions: Set<ReactionCount> = emptySet()
) : MessageListItemViewModel {

    override val uniqueAdapterId =
        (messageID.hashCode() + (messageCount?.hashCode() ?: 1)).asUniqueAdapterId()
}