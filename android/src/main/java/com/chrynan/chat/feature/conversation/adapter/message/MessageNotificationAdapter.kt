package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageNotificationItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_notification.view.*
import javax.inject.Inject

@Adapter
class MessageNotificationAdapter @Inject constructor() :
    BaseAdapter<MessageNotificationItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageNotificationItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_message_notification,
            parent,
            false
        )

    override fun onBindItem(view: View, item: MessageNotificationItemViewModel) {
        view.apply {
            messageNotificationTitleTextView?.text = item.title
            messageNotificationTitleTextView?.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                item.icon,
                null,
                null
            )
            messageNotificationDescriptionTextView?.text = item.description
            messageNotificationDescriptionTextView?.visibility =
                if (item.description == null) View.GONE else View.VISIBLE
        }
    }
}