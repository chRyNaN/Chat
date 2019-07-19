package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

data class ConversationListItemViewModel(
    val conversationId: ID,
    val imageUri: String? = null,
    val title: String,
    val description: String,
    val formattedDateTime: String
) : ViewModel