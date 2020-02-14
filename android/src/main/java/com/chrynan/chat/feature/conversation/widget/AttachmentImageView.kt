package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.graphics.Outline
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import com.chrynan.chat.R

class AttachmentImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    AppCompatImageView(context, attrs) {

    private val cornerRadius by lazy {
        resources.getDimensionPixelSize(R.dimen.attachment_image_corner_radius).toFloat()
    }
    private val defaultBackgroundColor by lazy { resources.getColor(R.color.white, null) }

    private val customOutlineProvider by lazy {
        object : ViewOutlineProvider() {

            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, cornerRadius)
            }
        }
    }

    init {
        outlineProvider = customOutlineProvider
        clipToOutline = true
        setBackgroundColor(defaultBackgroundColor)
    }
}