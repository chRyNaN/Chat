package com.chrynan.chat.utils

import android.view.View
import android.view.ViewOutlineProvider
import com.chrynan.chat.R

fun View.withOutline(
    viewOutlineProvider: ViewOutlineProvider,
    defaultBackgroundColorResId: Int = R.color.white
) {
    outlineProvider = viewOutlineProvider
    clipToOutline = true
    setBackgroundColor(resources.getColor(defaultBackgroundColorResId, null))
}