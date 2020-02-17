package com.chrynan.chat.feature.conversation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.AttachmentGalleryItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_attachment_gallery.view.*
import javax.inject.Inject

@Adapter
class AttachmentGalleryAdapter @Inject constructor(private val listener: AttachmentGalleryListener) :
    BaseAdapter<AttachmentGalleryItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is AttachmentGalleryItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_attachment_gallery,
            parent,
            false
        )

    override fun onBindItem(view: View, item: AttachmentGalleryItemViewModel) {
        view.apply {
            attachmentGalleryImageView?.load(item.uri)
            attachmentGalleryLabelTextView?.visibility =
                if (item.videoLengthLabel == null) View.GONE else View.VISIBLE
            attachmentGalleryLabelTextView?.text = item.videoLengthLabel
            attachmentGalleryCardView?.setOnClickListener { listener.onGalleryItemSelected(item) }
        }
    }

    interface AttachmentGalleryListener {

        fun onGalleryItemSelected(item: AttachmentGalleryItemViewModel)
    }
}