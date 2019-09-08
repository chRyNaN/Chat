package com.chrynan.chat.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrynan.chat.R
import com.chrynan.chat.delegates.textView
import com.chrynan.chat.view.ConversationListItemView

class ConversationListItemWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs),
    ConversationListItemView {

    private val titleTextView by lazy { findViewById<TextView>(R.id.titleTextView) }
    private val descriptionTextView by lazy { findViewById<TextView>(R.id.descriptionTextView) }
    private val timeTextView by lazy { findViewById<TextView>(R.id.timeTextView) }
    private val imageView by lazy { findViewById<UserImageView>(R.id.listItemImageView) }

    override var title by textView { titleTextView }
    override var description by textView { descriptionTextView }
    override var formattedDateTime by textView { timeTextView }
    override var imageUri: String? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_conversation_list_item, this, true)

        imageView.userImage = UserImageView.UserImage(
            name = "Chris",
            backgroundColorInt = resources.getColor(R.color.accent_three_color),
            textColorInt = resources.getColor(R.color.primary_dark_color),
            imageUri = null
        )
    }
}