package com.chrynan.chat.feature.conversation.viewmodel

import android.graphics.drawable.Drawable
import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageNotificationItemViewModel(
    override val messageID: ID,
    val title: String,
    val description: String? = null,
    val icon: Drawable? = null
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$title$description".asUniqueAdapterId()
}