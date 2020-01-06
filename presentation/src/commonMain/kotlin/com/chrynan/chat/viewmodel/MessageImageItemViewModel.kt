package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.decrypted.DecryptedAttachment
import com.chrynan.chat.model.core.ID

data class MessageImageItemViewModel(
    override val messageID: ID,
    val image: DecryptedAttachment.Image
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$image".asUniqueAdapterId()
}