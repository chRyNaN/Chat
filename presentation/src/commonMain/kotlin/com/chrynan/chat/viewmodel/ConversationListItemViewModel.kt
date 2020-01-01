package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID
import com.chrynan.chat.model.UserImage

data class ConversationListItemViewModel(
    val conversationId: ID,
    val userImage: UserImage? = null,
    val title: String,
    val description: String,
    val formattedDateTime: String
) : ViewModel