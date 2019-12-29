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
import com.chrynan.chat.resources.Colors
import com.chrynan.chat.ui.widget.UserImageView
import com.chrynan.chat.viewmodel.MessageHeaderItemViewModel
import kotlinx.android.synthetic.main.adapter_message_header.view.*

@Adapter
class MessageHeaderAdapter @Inject constructor(private val colors: Colors) : BaseAdapter<MessageHeaderItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageHeaderItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_header, parent, false)

    override fun onBindItem(view: View, item: MessageHeaderItemViewModel) {
        view.apply {
            headerNameTextView?.text = item.name
            headerHandleTextView?.text = item.handle
            headerHandleTextView?.visibility = if (item.handle == null) View.GONE else View.VISIBLE
            headerImageView?.userImage = UserImageView.UserImage(
                name = item.name,
                backgroundColorInt = colors.accentOne,
                textColorInt = colors.textDark,
                imageUri = item.image
            )
        }
    }
}