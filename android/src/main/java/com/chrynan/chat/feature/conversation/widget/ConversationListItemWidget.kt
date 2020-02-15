package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrynan.chat.R
import com.chrynan.chat.delegates.textView
import com.chrynan.chat.feature.conversation.view.ConversationListItemView
import com.chrynan.chat.model.UserImage
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
    override var showNewItemBadge: Boolean = false
        set(value) {
            field = value

            val textColor = if (value) textAccentColor else textSubtleColor
            val drawable = if (value) badgeDrawable else null

            timeTextView?.setTextColor(textColor)
            timeTextView?.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                drawable,
                null
            )
        }

    private val textSubtleColor by lazy { context.getColor(R.color.text_primary_subtle_color) }
    private val textAccentColor by lazy { context.getColor(R.color.conversation_new_item_badge_color) }

    private val badgeDrawable by lazy { context.getDrawable(R.drawable.ic_badge_conversation_new_item) }

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_conversation_list_item, this, true)
    }
}