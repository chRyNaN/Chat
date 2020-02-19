package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.decrypted.DecryptedAttachment
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageFileItemViewModel(
    override val messageID: ID,
    val file: DecryptedAttachment.File
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$file".asUniqueAdapterId()
}