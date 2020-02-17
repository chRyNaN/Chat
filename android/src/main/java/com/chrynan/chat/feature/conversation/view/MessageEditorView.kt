package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.view.View

interface MessageEditorView : View {

    fun showTextInput(input: String)

    fun toggleMediaListVisibility(isVisible: Boolean)

    fun toggleAttachmentTypeListVisibility(isVisible: Boolean)

    fun toggleAttachmentBackgroundVisibility(isVisible: Boolean)

    fun toggleAttachmentListVisibility(isVisible: Boolean)
}