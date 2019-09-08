package com.chrynan.chat.ui.widget.outline

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

open class BubbleViewOutlineProvider(
    private val minHeightRetriever: () -> Int,
    private val minCornerRadius: Float
) : ViewOutlineProvider() {

    override fun getOutline(view: View, outline: Outline) {
        val minHeight = minHeightRetriever.invoke()
        var diff = (view.height - minHeight).toFloat()
        diff = if (diff <= 0) diff else diff / 4
        val cornerRadius =
            ((minHeight - diff)).coerceAtLeast(minCornerRadius)

        outline.setRoundRect(0, 0, view.width, view.height, cornerRadius)
    }
}