package com.chrynan.chat.ui.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import com.chrynan.chat.viewmodel.MessageImageItemViewModel
import kotlinx.android.synthetic.main.adapter_message_image.view.*

@Adapter
class MessageImageAdapter @Inject constructor(private val listener: ImageSelectedListener) :
    BaseAdapter<MessageImageItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageImageItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_image, parent, false)

    override fun onBindItem(view: View, item: MessageImageItemViewModel) {
        view.apply {
            imageView?.load(item.image.uri)
            setOnClickListener { listener.onImageSelected(item) }
        }
    }

    interface ImageSelectedListener {

        fun onImageSelected(item: MessageImageItemViewModel)
    }
}