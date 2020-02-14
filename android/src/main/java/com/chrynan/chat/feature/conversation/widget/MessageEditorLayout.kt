package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.graphics.Outline
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.inputmethod.InputContentInfoCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.adapter.AttachmentItemAdapter
import com.chrynan.chat.feature.conversation.viewmodel.AttachmentListItemViewModel
import com.chrynan.chat.viewmodel.ViewModel

class MessageEditorLayout : ConstraintLayout,
    MessageEditText.MediaItemSelectedListener,
    AttachmentItemAdapter.RemoveItemListener {

    private val customOutlineProvider by lazy {
        object : ViewOutlineProvider() {

            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, cornerRadius)
            }
        }
    }

    private val cornerRadius: Float
        get() = (editText.measuredHeight + editText.paddingTop + editText.paddingBottom) / 2f

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.messageRecyclerView) }
    private val editText by lazy { findViewById<EditText>(R.id.messageEditText) }

    private val attachments =
        mutableListOf<AttachmentListItemViewModel>(
            AttachmentListItemViewModel(
                ""
            )
        )

    private val adapter: ManagerRecyclerViewAdapter<ViewModel>

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_message_editor, this, true)

        outlineProvider = customOutlineProvider
        clipToOutline = true

        val attachmentAdapter = AttachmentItemAdapter()
            .apply {
                listener = this@MessageEditorLayout
            }
        adapter = ManagerRecyclerViewAdapter(adapters = setOf(attachmentAdapter))

        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.visibility = View.VISIBLE

        adapter.items = attachments
    }

    override fun onViewAdded(view: View?) {
        super.onViewAdded(view)

        if (view != null && view is MessageEditText) {
            view.listener = this
        }
    }

    override fun onMediaItemSelected(contentInfo: InputContentInfoCompat) {
        attachments += AttachmentListItemViewModel(
            imageUri = contentInfo.contentUri.toString()
        )
        // TODO this should be optimized to use a diff util
        adapter.items = attachments
        toggleRecyclerViewVisibility()
    }

    override fun onRemoveItem(item: AttachmentListItemViewModel) {
        attachments -= item
        // TODO this should be optimized to use a diff util
        adapter.items = attachments
        toggleRecyclerViewVisibility()
    }

    private fun toggleRecyclerViewVisibility() {
        val result = recyclerView.itemAnimator?.isRunning {
            recyclerView.visibility = if (attachments.isEmpty()) View.GONE else View.VISIBLE
        }

        if (result == null) {
            recyclerView.visibility = if (attachments.isEmpty()) View.GONE else View.VISIBLE
        }
    }
}