package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageLinkPreviewItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_link_preview.view.*
import javax.inject.Inject

@Adapter
class MessageLinkPreviewAdapter @Inject constructor(private val listener: LinkPreviewListener) :
    BaseAdapter<MessageLinkPreviewItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageLinkPreviewItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_message_link_preview,
            parent,
            false
        )

    override fun onBindItem(view: View, item: MessageLinkPreviewItemViewModel) {
        view.apply {
            item.imageUri?.let { linkPreviewImageView?.load(it) }
            linkPreviewTitleTextView?.text = item.title
            linkPreviewDescriptionTextView?.text = item.description
            linkPreviewUrlTextView?.text = item.link
            linkPreviewCard?.setOnClickListener { listener.onLinkPreviewSelected(item) }
        }
    }

    interface LinkPreviewListener {

        fun onLinkPreviewSelected(item: MessageLinkPreviewItemViewModel)
    }
}