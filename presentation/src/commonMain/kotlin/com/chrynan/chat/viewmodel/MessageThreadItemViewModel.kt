package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

data class MessageThreadItemViewModel(
    override val messageID: ID,
    val messageCount: String?
) : MessageListItemViewModel