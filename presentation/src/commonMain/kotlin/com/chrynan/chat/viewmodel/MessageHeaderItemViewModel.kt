package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.UriString

data class MessageHeaderItemViewModel(
    override val messageID: ID,
    val name: String,
    val handle: String?,
    val image: UriString?,
    val date: String,
    val isOnline: Boolean = false
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$name".asUniqueAdapterId()
}