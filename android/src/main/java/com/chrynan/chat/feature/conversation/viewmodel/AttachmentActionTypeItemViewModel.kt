package com.chrynan.chat.feature.conversation.viewmodel

import android.graphics.drawable.Drawable
import com.chrynan.aaaah.AdapterId
import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.conversation.model.AttachmentActionType

data class AttachmentActionTypeItemViewModel(
    val type: AttachmentActionType,
    val title: String,
    val icon: Drawable? = null
) : AdapterItem {

    override val uniqueAdapterId: AdapterId
        get() = "$type;$title".asUniqueAdapterId()
}