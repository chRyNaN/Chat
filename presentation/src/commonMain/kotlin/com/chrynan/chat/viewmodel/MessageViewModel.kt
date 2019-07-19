package com.chrynan.chat.viewmodel

data class MessageViewModel(
    val messageInfo: MessageInfoViewModel,
    val threadInfo: ThreadInfoViewModel,
    val reactionInfo: ReactionInfoViewModel,
    val mediaInfo: MediaInfoViewModel,
    val verificationInfo: VerificationInfoViewModel,
    val text: String? = null
) : ViewModel