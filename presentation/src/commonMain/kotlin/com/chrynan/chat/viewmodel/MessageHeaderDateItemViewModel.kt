package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

data class MessageHeaderDateItemViewModel(
    override val messageID: ID,
    val date: String
) : MessageListItemViewModel