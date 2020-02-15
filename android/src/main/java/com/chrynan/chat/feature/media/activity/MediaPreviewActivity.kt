package com.chrynan.chat.feature.media.activity

import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.feature.media.fragment.AudioPreviewFragment
import com.chrynan.chat.feature.media.fragment.ImagePreviewFragment
import com.chrynan.chat.feature.media.fragment.VideoPreviewFragment
import com.chrynan.chat.feature.media.parcel.getMediaItemViewModel
import com.chrynan.chat.feature.media.parcel.putMediaItemViewModelExtra
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import com.chrynan.chat.feature.media.util.animateHide
import com.chrynan.chat.feature.media.util.animateShow
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.utils.ActivityContext
import kotlinx.android.synthetic.main.activity_media_preview.*
import java.io.Serializable

class MediaPreviewActivity : BaseActivity(),
    ToggleSystemUIListener {

    companion object {

        private const val KEY_MEDIA_TYPE = "KeyMediaPreviewActivityMediaType"
        private const val KEY_IMAGE_PREVIEW_MODEL = "KeyMediaPreviewActivityImagePreviewModel"

        fun newImageIntent(context: ActivityContext, model: MediaItemViewModel) =
            Intent(context, MediaPreviewActivity::class.java).apply {
                putExtra(KEY_MEDIA_TYPE, MediaType.IMAGE as Serializable)
                putMediaItemViewModelExtra(KEY_IMAGE_PREVIEW_MODEL, model)
            }

        fun newVideoIntent(context: ActivityContext, model: MediaItemViewModel) =
            Intent(context, MediaPreviewActivity::class.java).apply {
                putExtra(KEY_MEDIA_TYPE, MediaType.VIDEO as Serializable)
                putMediaItemViewModelExtra(KEY_IMAGE_PREVIEW_MODEL, model)
            }

        fun newAudioIntent(context: ActivityContext, model: MediaItemViewModel) =
            Intent(context, MediaPreviewActivity::class.java).apply {
                putExtra(KEY_MEDIA_TYPE, MediaType.AUDIO as Serializable)
                putMediaItemViewModelExtra(KEY_IMAGE_PREVIEW_MODEL, model)
            }
    }

    private val type by lazy { intent?.getSerializableExtra(KEY_MEDIA_TYPE)!! }
    private val model by lazy { intent?.getMediaItemViewModel(KEY_IMAGE_PREVIEW_MODEL) }

    private var showSystemUI: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_preview)

        setSupportActionBar(mediaPreviewToolbar)

        when (type) {
            MediaType.IMAGE -> goToFragment(ImagePreviewFragment.newInstance(model!!))
            MediaType.VIDEO -> goToFragment(VideoPreviewFragment.newInstance(model!!))
            MediaType.AUDIO -> goToFragment(AudioPreviewFragment.newInstance(model!!))
        }
    }

    override fun onToggleSystemUI() {
        showSystemUI = !showSystemUI

        if (showSystemUI) {
            mediaPreviewToolbar?.animateShow()
        } else {
            mediaPreviewToolbar?.animateHide()
        }
    }

    private enum class MediaType {

        IMAGE,
        VIDEO,
        AUDIO
    }
}