package com.chrynan.chat.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.coroutines.AndroidCoroutineDispatchers
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.ViewCoroutineScope
import com.chrynan.chat.view.AttachmentListItemView
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AttachmentLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs),
    AttachmentListItemView,
    ViewCoroutineScope {

    override var imageUri: String? = null
        set(value) {
            field = value

            value?.let {
                launch {
                    attachmentImageView.load(value.toUri()) {
                        error(R.drawable.bg_launcher)
                    }
                }
            }
        }

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    var badgeListener: BadgeSelectedListener? = null

    private val attachmentImageView by lazy { findViewById<AttachmentImageView>(R.id.attachmentImageView) }
    private val badgeImageView by lazy { findViewById<ImageView>(R.id.attachmentBadgeImageView) }

    private val dispatchers: CoroutineDispatchers = AndroidCoroutineDispatchers()
    private val job: Job

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_attachment, this, true)

        job = SupervisorJob()

        badgeImageView.setOnClickListener { badgeListener?.onBadgeSelected() }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        job.cancel()
    }

    interface BadgeSelectedListener {

        fun onBadgeSelected()
    }
}