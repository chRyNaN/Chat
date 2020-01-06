package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.decrypted.DecryptedAttachment
import com.chrynan.chat.model.ID

data class MessageFileItemViewModel(
    override val messageID: ID,
    val file: DecryptedAttachment.File
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$file".asUniqueAdapterId()
}