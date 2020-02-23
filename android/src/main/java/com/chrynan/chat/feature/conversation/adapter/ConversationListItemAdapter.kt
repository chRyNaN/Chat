package com.chrynan.chat.feature.conversation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.binder.ConversationListItemBinder
import com.chrynan.chat.feature.conversation.viewmodel.ConversationListItemViewModel
import com.chrynan.chat.feature.conversation.widget.ConversationListItemWidget
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

@Adapter
class ConversationListItemAdapter @Inject constructor(
    private val binder: ConversationListItemBinder,
    private val listener: ConversationListItemSelectedListener
) : BaseAdapter<ConversationListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ConversationListItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_conversation_list_item,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ConversationListItemViewModel) {
        (view as ConversationListItemWidget).apply {
            launch {
                binder.view = view
                binder.bind(item)
            }

            setOnClickListener { listener.onConversationListItemSelected(item) }
        }
    }

    interface ConversationListItemSelectedListener {

        fun onConversationListItemSelected(item: ConversationListItemViewModel)
    }
}