package com.chrynan.chat.model.decrypted

import com.chrynan.chat.model.MessageStatus
import com.chrynan.chat.model.MessageUser
import com.chrynan.chat.model.ReactionCount
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment

data class DecryptedMessage(
    override val id: ID,
    val dateTime: TimeMoment,
    val sender: MessageUser,
    val decryptedContent: String,
    val status: MessageStatus = MessageStatus.PENDING_SEND,
    val threadedReplyCount: Int = 0,
    val firstMessageInDate: Boolean = false,
    val reactions: List<ReactionCount> = emptyList(),
    val decryptedAttachments: List<DecryptedAttachment> = emptyList()
) : Node