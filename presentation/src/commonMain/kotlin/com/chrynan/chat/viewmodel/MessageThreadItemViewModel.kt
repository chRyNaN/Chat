package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

data class MessageThreadItemViewModel(
    val messageID: ID,
    val messageCount: String?
) : ViewModel