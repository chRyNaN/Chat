package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.ui.widget.AttachmentLayout
import com.chrynan.chat.viewmodel.AttachmentListItemViewModel
import com.chrynan.chat.di.Inject

@Adapter
class AttachmentItemAdapter @Inject constructor() : BaseAdapter<AttachmentListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    var listener: RemoveItemListener? = null

    override fun onHandlesItem(item: Any) = item is AttachmentListItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_attachment_list_item,
            parent,
            false
        )

    override fun onBindItem(view: View, item: AttachmentListItemViewModel) {
        (view as AttachmentLayout).apply {
            view.imageUri = item.imageUri
            view.badgeListener = object : AttachmentLayout.BadgeSelectedListener {
                override fun onBadgeSelected() {
                    listener?.onRemoveItem(item)
                }
            }
        }
    }

    interface RemoveItemListener {

        fun onRemoveItem(item: AttachmentListItemViewModel)
    }
}