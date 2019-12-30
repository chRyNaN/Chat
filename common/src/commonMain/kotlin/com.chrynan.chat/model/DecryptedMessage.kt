package com.chrynan.chat.model

class DecryptedMessage(
    override val id: ID,
    val dateTime: DateTime,
    val sender: User,
    val decryptedContent: String,
    val status: MessageStatus = MessageStatus.PENDING_SEND,
    val threadedReplyCount: Int = 0,
    val reactions: List<ReactionCount> = emptyList(),
    val encryptedAttachmentUris: List<UriString> = emptyList()
) : Node