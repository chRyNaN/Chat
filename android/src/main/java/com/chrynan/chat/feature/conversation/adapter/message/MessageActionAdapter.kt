package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageActionItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_action.view.*
import javax.inject.Inject

@Adapter
class MessageActionAdapter @Inject constructor(private val listener: MessageActionListener) :
    BaseAdapter<MessageActionItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageActionItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_action, parent, false)

    override fun onBindItem(view: View, item: MessageActionItemViewModel) {
        view.apply {
            messageThreadReplyCountTextView?.text = item.messageCount
            messageThreadReplyCountTextView?.visibility =
                if (item.messageCount == null) View.GONE else View.VISIBLE
            messageThreadReplyCountTextView?.setOnClickListener {
                listener.onMessageThreadSelected(
                    item
                )
            }
            messageReactionImageView?.setOnClickListener { listener.onSelectReactionSelected() }
            messageStatusTextView?.text = item.status
            messageStatusTextView?.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0,
                0,
                item.statusImageResourceID,
                0
            )
        }
    }

    interface MessageActionListener {

        fun onMessageThreadSelected(item: MessageActionItemViewModel)

        fun onSelectReactionSelected()
    }
}