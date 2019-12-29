package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.*
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.Reaction
import com.chrynan.chat.viewmodel.MessageReactionItemViewModel
import com.chrynan.chat.viewmodel.ViewModel

@Adapter
class MessageReactionAdapter @Inject constructor(
    private val listener: MessageReactionListener,
    private val adapter: ManagerRecyclerViewAdapter<ViewModel>
) : BaseAdapter<MessageReactionItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageReactionItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_reaction, parent, false)

    override fun onBindItem(view: View, item: MessageReactionItemViewModel) {
        view.apply {

        }
    }

    interface MessageReactionListener {

        fun onReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel)

        fun onAddReactionSelected(item: MessageReactionItemViewModel)
    }
}