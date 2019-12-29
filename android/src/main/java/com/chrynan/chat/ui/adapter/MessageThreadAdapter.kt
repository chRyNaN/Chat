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
import com.chrynan.chat.viewmodel.MessageThreadItemViewModel
import kotlinx.android.synthetic.main.adapter_message_thread.view.*

@Adapter
class MessageThreadAdapter @Inject constructor(private val listener: MessageThreadListener) :
    BaseAdapter<MessageThreadItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageThreadItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_thread, parent, false)

    override fun onBindItem(view: View, item: MessageThreadItemViewModel) {
        view.apply {
            messageThreadReplyCountTextView?.text = item.messageCount
            messageThreadReplyCountTextView?.visibility = if (item.messageCount == null) View.GONE else View.VISIBLE
            messageThreadContainer?.setOnClickListener { listener.onMessageThreadSelected(item) }
        }
    }

    interface MessageThreadListener {

        fun onMessageThreadSelected(item: MessageThreadItemViewModel)
    }
}