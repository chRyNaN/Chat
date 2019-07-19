package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.model.ID

sealed class MessageListItemViewModel : ViewModel {

    abstract val messageID: ID
    abstract val formattedTime: String
}

data class TextMessageListItemViewModel(
    override val messageID: ID,
    override val formattedTime: String,
    val text: String,
    val side: HorizontalPosition,
    val backgroundColorInt: ColorInt
) : MessageListItemViewModel()

data class ImageMessageListItemViewModel(
    override val messageID: ID,
    override val formattedTime: String,
    val imageUri: String
) : MessageListItemViewModel()