package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID
import com.chrynan.chat.resources.ResourceID

data class MessageStatusItemViewModel(
    override val messageID: ID,
    val status: String?,
    val image: ResourceID
) : MessageListItemViewModel