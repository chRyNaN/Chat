package com.chrynan.chat.feature.media.util

import android.widget.ImageView
import com.github.chrisbanes.photoview.OnOutsidePhotoTapListener
import com.github.chrisbanes.photoview.OnPhotoTapListener

interface ToggleSystemUIListener {

    fun onToggleSystemUI()
}

class ToggleSystemUITouchListener(private val listener: ToggleSystemUIListener) :
    OnPhotoTapListener,
    OnOutsidePhotoTapListener {

    override fun onPhotoTap(view: ImageView?, x: Float, y: Float) {
        listener.onToggleSystemUI()
    }

    override fun onOutsidePhotoTap(imageView: ImageView?) {
        listener.onToggleSystemUI()
    }
}