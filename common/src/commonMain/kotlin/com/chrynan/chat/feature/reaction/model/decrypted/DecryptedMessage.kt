package com.chrynan.chat.feature.reaction.model.decrypted

import com.chrynan.chat.feature.reaction.model.*
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.TimeMoment

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