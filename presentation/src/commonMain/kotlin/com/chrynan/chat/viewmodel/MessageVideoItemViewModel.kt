package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.model.decrypted.DecryptedAttachment
import com.chrynan.chat.model.core.ID

data class MessageVideoItemViewModel(
    override val messageID: ID,
    val video: DecryptedAttachment.Video
) : MessageListItemViewModel {

    override val uniqueAdapterId = "$messageID:$video".asUniqueAdapterId()
}