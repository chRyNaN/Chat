package com.chrynan.chat.ui.widget.outline

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class RoundedCornerViewOutlineProvider(val cornerRadius: Float) : ViewOutlineProvider() {

    override fun getOutline(view: View, outline: Outline) {
        outline.setRoundRect(0, 0, view.measuredWidth, view.measuredHeight, cornerRadius)
    }
}