package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.aaaah.ViewType
import com.chrynan.chat.R
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.ui.widget.TextViewBubbleViewOutlineProvider
import com.chrynan.chat.viewmodel.TextMessageListItemViewModel

class TextMessageListItemAdapter : BaseHorizontalAdapter<TextMessageListItemViewModel>() {

    override val startPositionViewType = AdapterViewTypes.START_TEXT_MESSAGE_LIST_ITEM
    override val endPositionViewType = AdapterViewTypes.END_TEXT_MESSAGE_LIST_ITEM

    override fun onHandlesItem(item: Any, position: HorizontalPosition): Boolean {
        if (item is TextMessageListItemViewModel) {
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
            HorizontalPosition.START -> R.layout.adapter_text_message_list_item_start
            HorizontalPosition.END -> R.layout.adapter_text_message_list_item_end
        }

        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val cornerRadius =
            view.resources.getDimensionPixelSize(R.dimen.message_item_min_corner_radius).toFloat()

        view.findViewById<TextView>(R.id.textMessageTextView).apply {
            outlineProvider = TextViewBubbleViewOutlineProvider(
                textView = this,
                minCornerRadius = cornerRadius
            )
            clipToOutline = true
        }

        return view
    }

    override fun onBind(
        view: View,
        item: TextMessageListItemViewModel,
        position: HorizontalPosition
    ) {
        val textView = view.findViewById<TextView>(R.id.textMessageTextView)

        textView.text = item.text
        textView.setBackgroundColor(item.backgroundColorInt)
    }
}