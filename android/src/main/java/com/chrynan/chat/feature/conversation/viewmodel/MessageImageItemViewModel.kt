package com.chrynan.chat.feature.conversation.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.feature.reaction.model.decrypted.DecryptedAttachment
import com.chrynan.chat.feature.reaction.model.core.ID

data class MessageImageItemViewModel(
    override val messageID: ID,
    val image: DecryptedAttachment.Image
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID$image".asUniqueAdapterId()
}