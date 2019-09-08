package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.chrynan.aaaah.ViewType
import com.chrynan.chat.R
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.ui.widget.outline.RoundedCornerViewOutlineProvider
import com.chrynan.chat.utils.withOutline
import com.chrynan.chat.viewmodel.ImageMessageListItemViewModel

class ImageMessageListItemAdapter : BaseHorizontalAdapter<ImageMessageListItemViewModel>() {

    override val startPositionViewType = AdapterViewTypes.START_IMAGE_MESSAGE_LIST_ITEM
    override val endPositionViewType = AdapterViewTypes.END_IMAGE_MESSAGE_LIST_ITEM

    override fun onHandlesItem(item: Any, position: HorizontalPosition): Boolean {
        if (item is ImageMessageListItemViewModel) {
            return item.side == position
        }

        return false
    }

    override fun onCreateView(
        parent: ViewGroup,
        viewType: ViewType,
        position: HorizontalPosition
    ): View {
        val layoutResId = when (position) {
            HorizontalPosition.START -> R.layout.adapter_image_message_list_item_start
            HorizontalPosition.END -> R.layout.adapter_image_message_list_item_end
        }

        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.messageImageView)

        val cornerRadius = view.resources.getDimension(R.dimen.message_item_corner_radius)

        imageView.withOutline(RoundedCornerViewOutlineProvider(cornerRadius))

        return view
    }

    override fun onBind(
        view: View,
        item: ImageMessageListItemViewModel,
        position: HorizontalPosition
    ) {
        //view.findViewById<ImageView>(R.id.messageImageView).load(Uri.parse(item.imageUri))
    }
}