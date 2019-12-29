package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID
import com.chrynan.chat.model.UriString

data class MessageHeaderItemViewModel(
    override val messageID: ID,
    val name: String,
    val handle: String?,
    val image: UriString
) : MessageListItemViewModel