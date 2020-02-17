package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.view.MessageEditorEditTextView
import com.chrynan.chat.ui.widget.outline.RoundedCornerViewOutlineProvider
import kotlinx.android.synthetic.main.widget_message_editor_edit_text.view.*

/**
 * A custom layout that wraps the edit text, attachment button, and attachments recycler view.
 */
class MessageEditorEditTextLayout : ConstraintLayout,
    MessageEditorEditTextView {

    private val customOutlineProvider by lazy { RoundedCornerViewOutlineProvider(cornerRadius) }

    private val cornerRadius by lazy {
        context.resources.getDimensionPixelSize(R.dimen.message_editor_corner_radius).toFloat()
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_message_editor_edit_text, this, true)

        outlineProvider = customOutlineProvider
        clipToOutline = true
    }

    override fun showTextInput(input: String) {
        messageEditorEditText?.setText(input)
    }

    override fun toggleAttachmentListVisibility(isVisible: Boolean) {
        messageEditorAttachmentRecyclerView?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}