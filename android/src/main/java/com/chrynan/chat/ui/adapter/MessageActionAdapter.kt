package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.*
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.Reaction
import com.chrynan.chat.viewmodel.MessageActionItemViewModel
import com.chrynan.chat.viewmodel.MessageReactionItemViewModel
import com.chrynan.chat.viewmodel.ViewModel
import kotlinx.android.synthetic.main.adapter_message_action.view.*
import javax.inject.Named

@Adapter
class MessageActionAdapter @Inject constructor(
    private val listener: MessageActionListener,
    @Named("ReactionAdapter") private val adapter: BaseManagerAdapter<AdapterItem>
) : BaseAdapter<MessageActionItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageActionItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_action, parent, false)

    override fun onBindItem(view: View, item: MessageActionItemViewModel) {
        view.apply {
            messageThreadReplyCountTextView?.text = item.messageCount
            messageThreadReplyCountTextView?.visibility = if (item.messageCount == null) View.GONE else View.VISIBLE
            messageThreadReplyCountTextView?.setOnClickListener { listener.onMessageThreadSelected(item) }
            messageReactionImageView?.setOnClickListener { }
            messageStatusTextView?.text = item.status
            messageStatusTextView?.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, item.statusImageResourceID, 0)
            messageReactionRecyclerView?.visibility = if (item.reactions.isEmpty()) View.GONE else View.VISIBLE
            // TODO handle showing the selected reactions
        }
    }

    interface MessageActionListener {

        fun onMessageThreadSelected(item: MessageActionItemViewModel)

        fun onRemoveReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel)

        fun onAddReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel)
    }
}