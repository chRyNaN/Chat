package com.chrynan.chat.utils

import android.view.View
import android.view.ViewOutlineProvider
import com.chrynan.chat.R
import com.chrynan.chat.view.NotificationView
import com.google.android.material.snackbar.Snackbar

fun View.withOutline(
    viewOutlineProvider: ViewOutlineProvider,
    defaultBackgroundColorResId: Int = R.color.white
) {
    outlineProvider = viewOutlineProvider
    clipToOutline = true
    setBackgroundColor(resources.getColor(defaultBackgroundColorResId, null))
}

fun snackbarOf(
    view: View,
    message: String,
    type: NotificationView.Type = NotificationView.Type.MESSAGE,
    length: NotificationView.Length = NotificationView.Length.SHORT,
    action: NotificationView.Action? = null
): Snackbar {
    val duration = when (length) {
        NotificationView.Length.SHORT -> Snackbar.LENGTH_SHORT
        NotificationView.Length.LONG -> Snackbar.LENGTH_LONG
        NotificationView.Length.INDEFINITE -> Snackbar.LENGTH_INDEFINITE
    }

    return Snackbar.make(view, message, duration).apply {
        if (action != null) {
            setAction(action.title) { action.block() }
        }

        // TODO use type to change the text, action text, and background color
    }
}