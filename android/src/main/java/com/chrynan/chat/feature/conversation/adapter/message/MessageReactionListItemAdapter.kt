package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageReactionListItemViewModel
import com.chrynan.chat.feature.reaction.model.load
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_reaction_list_item.view.*
import javax.inject.Inject

@Adapter
class MessageReactionListItemAdapter @Inject constructor(private val listener: MessageReactionSelectedListener) :
    BaseAdapter<MessageReactionListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageReactionListItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_message_reaction_list_item,
            parent,
            false
        )

    override fun onBindItem(view: View, item: MessageReactionListItemViewModel) {
        view.apply {
            messageReactionItemCountTextView?.text = item.count.toString()
            messageReactionItemEmojiImageView?.load(item.emoji)
            setOnClickListener { listener.onMessageReactionSelected(item) }
        }
    }

    interface MessageReactionSelectedListener {

        fun onMessageReactionSelected(item: MessageReactionListItemViewModel)
    }
}