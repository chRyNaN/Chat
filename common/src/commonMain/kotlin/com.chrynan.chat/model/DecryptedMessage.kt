package com.chrynan.chat.model

class DecryptedMessage(
    override val id: ID,
    val dateTime: TimeMoment,
    val sender: User,
    val decryptedContent: String,
    val status: MessageStatus = MessageStatus.PENDING_SEND,
    val threadedReplyCount: Int = 0,
    val firstMessageInDate: Boolean = false,
    val reactions: List<ReactionCount> = emptyList(),
    val senderReactions: List<Reaction> = emptyList(),
    val encryptedAttachmentUris: List<UriString> = emptyList()
) : Node