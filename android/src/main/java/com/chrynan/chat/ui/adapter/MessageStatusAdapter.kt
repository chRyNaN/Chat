package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.viewmodel.MessageStatusItemViewModel
import kotlinx.android.synthetic.main.adapter_message_status.view.*

class MessageStatusAdapter @Inject constructor() : BaseAdapter<MessageStatusItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageStatusItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_status, parent, false)

    override fun onBindItem(view: View, item: MessageStatusItemViewModel) {
        view.apply {
            statusImageView?.setImageResource(item.image)
            statusTextView?.text = item.status
            statusTextView?.visibility = if (item.status == null) View.GONE else View.VISIBLE
        }
    }
}