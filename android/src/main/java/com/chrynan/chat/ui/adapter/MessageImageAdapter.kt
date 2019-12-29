package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.ui.widget.outline.RoundedCornerViewOutlineProvider
import com.chrynan.chat.utils.withOutline
import com.chrynan.chat.viewmodel.MessageImageItemViewModel
import com.chrynan.chat.di.Inject

@Adapter
class MessageImageAdapter @Inject constructor() : BaseAdapter<MessageImageItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageImageItemViewModel

    override fun onCreateView(
        parent: ViewGroup,
        viewType: ViewType
    ): View {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_image, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.messageImageView)

        val cornerRadius = view.resources.getDimension(R.dimen.message_item_corner_radius)

        imageView.withOutline(RoundedCornerViewOutlineProvider(cornerRadius))

        return view
    }

    override fun onBindItem(view: View, item: MessageImageItemViewModel) {

    }
}