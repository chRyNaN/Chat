package com.chrynan.chat.feature.media.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.appcompat.widget.Toolbar

fun Toolbar.animateHide() {
    animate()
        .alpha(0f)
        .translationY(-height.toFloat())
        .setListener(object : AnimatorListenerAdapter() {

            override fun onAnimationEnd(animation: Animator?) {
                visibility = View.GONE
            }
        })
        .start()
}

fun Toolbar.animateShow() {
    alpha = 0f
    visibility = View.VISIBLE

    animate()
        .alpha(1f)
        .translationY(0f)
        .setListener(null)
        .start()
}