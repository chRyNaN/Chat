package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.UserImage
import com.chrynan.chat.model.core.ID

data class ConversationListItemViewModel(
    val conversationId: ID,
    val userImage: UserImage? = null,
    val title: String,
    val description: String,
    val formattedDateTime: String,
    val showNewItemBadge: Boolean = false
) : AdapterItem {

    override val uniqueAdapterId = conversationId.asUniqueAdapterId()
}