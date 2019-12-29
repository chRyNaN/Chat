package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.model.ID

data class MessageTextItemViewModel(
    val messageID: ID,
    val formattedTime: String,
    val text: String,
    val side: HorizontalPosition,
    val backgroundColorInt: ColorInt
) : ViewModel