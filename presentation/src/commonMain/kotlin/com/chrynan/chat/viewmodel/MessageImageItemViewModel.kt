package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.model.ID

data class MessageImageItemViewModel(
    val messageID: ID,
    val formattedTime: String,
    val imageUri: String,
    val side: HorizontalPosition
) : ViewModel