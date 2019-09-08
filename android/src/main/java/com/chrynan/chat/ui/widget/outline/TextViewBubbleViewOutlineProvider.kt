package com.chrynan.chat.ui.widget.outline

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