package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.binder.ConversationListItemBinder
import com.chrynan.chat.ui.activity.ConversationActivity
import com.chrynan.chat.ui.widget.ConversationListItemWidget
import com.chrynan.chat.viewmodel.ConversationListItemViewModel
import kotlinx.coroutines.launch
import com.chrynan.chat.di.Inject
import com.chrynan.chat.ui.adapter.core.BaseAdapter

@Adapter
class ConversationListItemAdapter @Inject constructor() : BaseAdapter<ConversationListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    private val binder = ConversationListItemBinder()

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
            setOnClickListener {
                view.context?.let {
                    it.startActivity(
                        ConversationActivity.newIntent(
                            it
                        )
                    )
                }
            }
        }
    }
}