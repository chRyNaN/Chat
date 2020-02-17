package com.chrynan.chat.feature.conversation.viewmodel

import android.graphics.drawable.Drawable
import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem

data class MessageTypingItemViewModel(
    val text: String,
    val icon: Drawable? = null
) : AdapterItem {

    override val uniqueAdapterId = text.asUniqueAdapterId()
}