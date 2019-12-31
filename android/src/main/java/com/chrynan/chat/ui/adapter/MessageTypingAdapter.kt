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
import com.chrynan.chat.viewmodel.MessageTypingItemViewModel
import kotlinx.android.synthetic.main.adapter_message_typing.view.*

@Adapter
class MessageTypingAdapter @Inject constructor() : BaseAdapter<MessageTypingItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageTypingItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_typing, parent, false)

    override fun onBindItem(view: View, item: MessageTypingItemViewModel) {
        view.apply {
            messageTypingTextView?.text = item.text
        }
    }
}