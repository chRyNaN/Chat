package com.chrynan.chat.model

data class MessageIDInfo(
    val providerUri: Uri,
    val groupID: ID,
    val messageID: ID,
    val senderID: ID
)