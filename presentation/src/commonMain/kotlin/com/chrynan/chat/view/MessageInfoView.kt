package com.chrynan.chat.view

import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.model.Uri

interface MessageInfoView : View {

    fun showMessageTime(time: String)

    fun showSenderInfo(name: String, imageUri: Uri)

    fun showProviderInfo(name: String)

    fun updateBackgroundColor(color: ColorInt)

    fun updateSide(side: HorizontalPosition)
}