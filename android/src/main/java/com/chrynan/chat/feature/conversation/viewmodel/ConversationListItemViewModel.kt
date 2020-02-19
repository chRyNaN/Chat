package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.chat.feature.reaction.model.UserImage
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.viewmodel.ViewModel

data class ConversationListItemViewModel(
    val conversationId: ID,
    val userImage: UserImage? = null,
    val title: String,
    val description: String,
    val formattedDateTime: String,
    val showNewItemBadge: Boolean = false
) : ViewModel