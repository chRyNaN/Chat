package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem

data class MessageTypingItemViewModel(
    val text: String
) : AdapterItem {

    override val uniqueAdapterId = text.asUniqueAdapterId()
}