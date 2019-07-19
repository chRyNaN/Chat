package com.chrynan.chat.ui.widget

import android.widget.TextView

class TextViewBubbleViewOutlineProvider(
    minCornerRadius: Float,
    private val textView: TextView
) : BubbleViewOutlineProvider(
    minCornerRadius = minCornerRadius,
    minHeightRetriever = {
        textView.run { ((lineHeight + lineSpacingExtra) * lineSpacingMultiplier).toInt() }
    }
)