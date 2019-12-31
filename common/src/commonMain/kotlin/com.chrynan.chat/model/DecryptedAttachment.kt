package com.chrynan.chat.model

data class DecryptedAttachment(
    val decryptedName: String,
    val uri: UriString,
    val type: AttachmentType
)