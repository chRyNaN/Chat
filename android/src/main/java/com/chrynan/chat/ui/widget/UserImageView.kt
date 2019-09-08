package com.chrynan.chat.ui.widget

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.ui.widget.outline.OvalViewOutlineProvider
import com.chrynan.chat.utils.withOutline

class UserImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs) {

    var userImage: UserImage? = null
        set(value) {
            field = value

            if (value != null) {
                setBackgroundColor(value.backgroundColorInt)

                if (value.imageUri != null) {
                    textView?.visibility = View.GONE
                    imageView?.visibility = View.VISIBLE
                    imageView?.load(Uri.parse(value.imageUri))
                } else {
                    textView?.visibility = View.VISIBLE
                    imageView?.visibility = View.GONE
                    textView?.setTextColor(value.textColorInt)
                    textView?.text = value.name.firstOrNull()?.toString()
                }
            }
        }

    private val imageView: ImageView? by lazy { findViewById<ImageView>(R.id.userImageView) }
    private val textView: TextView? by lazy { findViewById<TextView>(R.id.userTextView) }

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_user_image_view, this, true)

        withOutline(
            viewOutlineProvider = OvalViewOutlineProvider(),
            defaultBackgroundColorResId = R.color.accent_three_color
        )
    }

    data class UserImage(
        val name: String,
        val backgroundColorInt: ColorInt,
        val textColorInt: ColorInt,
        val imageUri: String? = null
    )
}