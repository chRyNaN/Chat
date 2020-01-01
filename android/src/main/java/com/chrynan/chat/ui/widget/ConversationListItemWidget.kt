package com.chrynan.chat.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrynan.chat.R
import com.chrynan.chat.delegates.textView
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.view.ConversationListItemView
import kotlinx.android.synthetic.main.widget_conversation_list_item.view.*

class ConversationListItemWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs),
    ConversationListItemView {

    override var title by textView { titleTextView }
    override var description by textView { descriptionTextView }
    override var formattedDateTime by textView { timeTextView }
    override var userImage: UserImage? = null
        set(value) {
            field = value

            itemImageView?.userImage = value
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_conversation_list_item, this, true)
    }
}