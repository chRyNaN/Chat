package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.*

data class MessageInfoViewModel(
    val time: Long,
    val formattedTime: String,
    val senderName: String,
    val senderImage: Uri,
    val side: HorizontalPosition,
    val textPosition: VerticalPosition,
    val idInfo: MessageIDInfo,
    val providerName: String,
    val backgroundColor: ColorInt
) : ViewModel