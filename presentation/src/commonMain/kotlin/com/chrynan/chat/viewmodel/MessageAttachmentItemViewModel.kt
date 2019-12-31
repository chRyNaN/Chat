package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.DecryptedAttachment
import com.chrynan.chat.model.ID

data class MessageAttachmentItemViewModel(
    override val messageID: ID,
    val attachment: DecryptedAttachment
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID:$attachment".asUniqueAdapterId()
}