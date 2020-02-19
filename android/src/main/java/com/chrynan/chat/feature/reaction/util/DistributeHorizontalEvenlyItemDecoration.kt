package com.chrynan.chat.feature.reaction.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DistributeHorizontalEvenlyItemDecoration(
    private val columnCount: Int,
    private val itemWidth: Int
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val horizontalOffset = (parent.measuredWidth % itemWidth) / columnCount

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.left = horizontalOffset
        } else {
            outRect.left = horizontalOffset
        }

        outRect.right = outRect.left + itemWidth
    }
}