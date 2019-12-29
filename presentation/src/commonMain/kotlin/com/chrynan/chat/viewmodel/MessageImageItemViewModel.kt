package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

data class MessageImageItemViewModel(
    override val messageID: ID,
    val imageUri: String
) : MessageListItemViewModel