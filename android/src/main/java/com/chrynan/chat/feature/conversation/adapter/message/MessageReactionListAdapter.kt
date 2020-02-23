package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.conversation.di.MessageReactionListModule
import com.chrynan.chat.feature.conversation.viewmodel.MessageReactionListViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import kotlinx.android.synthetic.main.adapter_message_reaction_list.view.*
import javax.inject.Inject
import javax.inject.Named

@Adapter
class MessageReactionListAdapter @Inject constructor(
    @Named(MessageReactionListModule.NAME_LAYOUT_MANAGER) private val layoutManager: LinearLayoutManager,
    private val listItemAdapter: MessageReactionListItemAdapter
) : BaseAdapter<MessageReactionListViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageReactionListViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_message_reaction_list,
            parent,
            false
        )

    override fun onBindItem(view: View, item: MessageReactionListViewModel) {
        view.apply {
            // We have to manually instantiate an Adapter here because we can't reuse one for all the items.
            // Otherwise, whenever we change the values on the adapter, the items will change on all the
            // adapters using that one adapter.
            val adapter = BaseManagerAdapter<AdapterItem>(setOf(listItemAdapter), layoutManager)

            messageReactionListRecyclerView?.layoutManager = layoutManager
            messageReactionListRecyclerView?.adapter = adapter

            adapter.items = item.reactions
        }
    }
}