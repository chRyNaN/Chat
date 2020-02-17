package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.view.View

interface MessageEditorEditTextView : View {

    fun showTextInput(input: String)

    fun toggleAttachmentListVisibility(isVisible: Boolean)
}