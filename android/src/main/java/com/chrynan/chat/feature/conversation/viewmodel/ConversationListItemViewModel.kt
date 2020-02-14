package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.viewmodel.ViewModel

data class ConversationListItemViewModel(
    val conversationId: ID,
    val userImage: UserImage? = null,
    val title: String,
    val description: String,
    val formattedDateTime: String
) : ViewModel