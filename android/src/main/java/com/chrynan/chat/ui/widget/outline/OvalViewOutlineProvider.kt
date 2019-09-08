package com.chrynan.chat.ui.widget.outline

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class OvalViewOutlineProvider : ViewOutlineProvider() {

    override fun getOutline(view: View, outline: Outline) {
        outline.setOval(0, 0, view.measuredWidth, view.measuredHeight)
    }
}