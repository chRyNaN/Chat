package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageFileItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_file.view.*
import javax.inject.Inject

@Adapter
class MessageFileAdapter @Inject constructor(private val listener: FileSelectedListener) :
    BaseAdapter<MessageFileItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageFileItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_file, parent, false)

    override fun onBindItem(view: View, item: MessageFileItemViewModel) {
        view.apply {
            fileTitleTextView?.text = item.file.decryptedName
            fileUrlTextView?.text = item.file.uri
            setOnClickListener { listener.onFileSelected(item) }
        }
    }

    interface FileSelectedListener {

        fun onFileSelected(item: MessageFileItemViewModel)
    }
}