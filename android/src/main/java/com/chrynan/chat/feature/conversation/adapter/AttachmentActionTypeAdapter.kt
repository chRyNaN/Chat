package com.chrynan.chat.feature.conversation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.model.AttachmentActionType
import com.chrynan.chat.feature.conversation.viewmodel.AttachmentActionTypeItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_attachment_action_type.view.*
import javax.inject.Inject

@Adapter
class AttachmentActionTypeAdapter @Inject constructor(private val listener: AttachmentActionTypeListener) :
    BaseAdapter<AttachmentActionTypeItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is AttachmentActionTypeItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_attachment_action_type,
            parent,
            false
        )

    override fun onBindItem(view: View, item: AttachmentActionTypeItemViewModel) {
        view.apply {
            attachmentTypeTextView?.apply {
                text = item.title
                setCompoundDrawablesRelativeWithIntrinsicBounds(null, item.icon, null, null)
                setOnClickListener { listener.onAttachmentActionTypeSelected(item.type) }
            }
        }
    }

    interface AttachmentActionTypeListener {

        fun onAttachmentActionTypeSelected(type: AttachmentActionType)
    }
}