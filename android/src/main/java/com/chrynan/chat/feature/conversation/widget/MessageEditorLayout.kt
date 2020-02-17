package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.view.MessageEditorView
import kotlinx.android.synthetic.main.widget_message_editor.view.*
import kotlinx.android.synthetic.main.widget_message_editor_edit_text.view.*

/**
 * A custom layout that wraps the edit text with attachments layout, the action button
 * (send/add attachment), and the choose attachments layout.
 */
class MessageEditorLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs),
    MessageEditorView {

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_message_editor, this, true)

        messageEditorActionButton?.setOnClickListener { messageEditorListener?.onActionButtonSelected() }
        messageEditorEditTextLayout?.messageEditorAttachmentButton?.setOnClickListener { messageEditorListener?.onAttachmentButtonSelected() }
    }

    var messageEditorListener: MessageEditorListener? = null

    override fun showTextInput(input: String) {
        messageEditorEditTextLayout?.showTextInput(input)
    }

    override fun toggleMediaListVisibility(isVisible: Boolean) {
        messageEditorMediaRecyclerView?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    override fun toggleAttachmentTypeListVisibility(isVisible: Boolean) {
        messageEditorAttachmentTypeRecyclerView?.visibility =
            if (isVisible) View.VISIBLE else View.GONE
    }

    override fun toggleAttachmentBackgroundVisibility(isVisible: Boolean) {
        messageEditorAttachmentBackgroundView?.visibility =
            if (isVisible) View.VISIBLE else View.GONE
    }

    override fun toggleAttachmentListVisibility(isVisible: Boolean) {
        messageEditorEditTextLayout?.toggleAttachmentListVisibility(isVisible)
    }

    interface MessageEditorListener {

        fun onAttachmentButtonSelected()

        fun onActionButtonSelected()
    }
}