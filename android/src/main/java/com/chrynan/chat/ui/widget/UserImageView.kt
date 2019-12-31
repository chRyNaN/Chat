package com.chrynan.chat.ui.widget

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.model.UriString
import com.chrynan.chat.ui.widget.outline.OvalViewOutlineProvider
import com.chrynan.chat.utils.withOutline
import kotlinx.android.synthetic.main.widget_user_image_view.view.*
import kotlin.math.min

class UserImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs) {

    var userImage: UserImage? = null
        set(value) {
            field = value

            if (value != null) {
                userTextView?.setBackgroundColor(value.backgroundColorInt)

                if (value.imageUri != null) {
                    userTextView?.visibility = View.INVISIBLE
                    userImageView?.visibility = View.VISIBLE
                    userImageView?.load(Uri.parse(value.imageUri))
                } else {
                    userTextView?.visibility = View.VISIBLE
                    userImageView?.visibility = View.GONE
                    userTextView?.setTextColor(value.textColorInt)
                    userTextView?.text = value.name.firstOrNull()?.toString()
                }

                badgeView?.visibility = if (value.badgeColorInt == null) View.GONE else View.VISIBLE
                value.badgeColorInt?.let { badgeView?.setBackgroundColor(it) }
            }
        }

    private var updateBadgePositioning = false
    private var badgePositionRadius = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_user_image_view, this, true)

        userTextView?.withOutline(
            viewOutlineProvider = OvalViewOutlineProvider(),
            defaultBackgroundColorResId = R.color.accent_three_color
        )

        badgeView?.withOutline(
            viewOutlineProvider = OvalViewOutlineProvider(),
            defaultBackgroundColorResId = R.color.offline_color
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        updateBadgePositioning = true
        badgePositionRadius = min((userTextView?.measuredHeight ?: 1), (userTextView?.measuredWidth ?: 1)) / 2
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (updateBadgePositioning) {
            updateBadgePositioning = false

            val params = badgeView?.layoutParams as? LayoutParams

            post {
                params?.circleRadius = badgePositionRadius
                badgeView?.layoutParams = params
            }
        }
    }

    data class UserImage(
        val name: String,
        val backgroundColorInt: ColorInt,
        val textColorInt: ColorInt,
        val badgeColorInt: ColorInt? = null,
        val imageUri: UriString? = null
    )
}