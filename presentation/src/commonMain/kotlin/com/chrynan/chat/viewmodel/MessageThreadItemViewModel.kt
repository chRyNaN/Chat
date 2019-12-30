package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.ID

data class MessageThreadItemViewModel(
    override val messageID: ID,
    val messageCount: String?
) : MessageListItemViewModel {

    override val uniqueAdapterId = (messageID.hashCode() + (messageCount?.hashCode() ?: 1)).asUniqueAdapterId()
}