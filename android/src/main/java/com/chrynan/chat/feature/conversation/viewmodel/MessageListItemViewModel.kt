package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.model.core.ID

interface MessageListItemViewModel : AdapterItem {

    val messageID: ID
}