package com.chrynan.chat.view

import com.chrynan.chat.model.VerticalPosition

interface MessageView : View,
    MessageInfoView,
    ReactionInfoView,
    ThreadInfoView,
    VerificationInfoView,
    MediaInfoView {

    fun showText(text: String, textPosition: VerticalPosition = VerticalPosition.TOP)

    fun hideText()
}