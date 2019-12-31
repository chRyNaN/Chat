package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.AttachmentType
import com.chrynan.chat.viewmodel.MessageAttachmentItemViewModel
import kotlinx.android.synthetic.main.adapter_message_attachment.view.*

@Adapter
class MessageAttachmentAdapter @Inject constructor() : BaseAdapter<MessageAttachmentItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageAttachmentItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_attachment, parent, false)

    override fun onBindItem(view: View, item: MessageAttachmentItemViewModel) {
        view.apply {
            when (item.attachment.type) {
                AttachmentType.FILE -> mediaItemWidget?.loadFile(item.attachment.uri)
                AttachmentType.AUDIO -> {
                    // TODO
                }
                AttachmentType.VIDEO -> {
                    // TODO
                }
                AttachmentType.IMAGE -> mediaItemWidget?.loadImage(item.attachment.uri)
            }
        }
    }

    override fun onEnter(view: View?, item: MessageAttachmentItemViewModel?) {
        super.onEnter(view, item)
        view?.apply {
            mediaItemWidget?.resume()
        }
    }

    override fun onExit(view: View?, item: MessageAttachmentItemViewModel?) {
        super.onExit(view, item)
        view?.apply {
            mediaItemWidget?.pause()
        }
    }
}