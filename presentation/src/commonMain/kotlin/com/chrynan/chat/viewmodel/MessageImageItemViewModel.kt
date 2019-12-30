package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.ID

data class MessageImageItemViewModel(
    override val messageID: ID,
    val imageUri: String
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$imageUri".asUniqueAdapterId()
}