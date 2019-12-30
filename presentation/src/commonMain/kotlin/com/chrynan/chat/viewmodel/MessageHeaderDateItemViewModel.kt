package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.ID

data class MessageHeaderDateItemViewModel(
    override val messageID: ID,
    val date: String
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$date".asUniqueAdapterId()
}