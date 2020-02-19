package com.chrynan.chat.feature.media.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.feature.media.parcel.getMediaItemViewModel
import com.chrynan.chat.feature.media.parcel.putMediaItemViewModel
import com.chrynan.chat.feature.media.presenter.VideoPreviewPresenter
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import com.chrynan.chat.feature.media.util.ToggleSystemUITouchListener
import com.chrynan.chat.feature.media.view.VideoPreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.feature.reaction.model.core.UriString
import com.chrynan.chat.ui.fragment.BaseFragment
import com.google.android.exoplayer2.Player
import kotlinx.android.synthetic.main.fragment_video_preview.*
import javax.inject.Inject

class VideoPreviewFragment : BaseFragment(),
    VideoPreviewView {

    companion object {

        private const val KEY_MEDIA_ITEM_MODEL = "KeyVideoPreviewFragmentMediaItemViewModel"

        fun newInstance(model: MediaItemViewModel) = VideoPreviewFragment().apply {
            arguments = Bundle().apply {
                putMediaItemViewModel(KEY_MEDIA_ITEM_MODEL, model)
            }
        }
    }

    @Inject
    override lateinit var presenter: VideoPreviewPresenter

    @Inject
    lateinit var toggleSystemUIListener: ToggleSystemUIListener

    private val model by lazy { arguments?.getMediaItemViewModel(KEY_MEDIA_ITEM_MODEL)!! }

    private val systemUITouchListener by lazy { ToggleSystemUITouchListener(toggleSystemUIListener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_video_preview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setup(model = model)
    }

    override fun attachPlayer(player: Player) {
        videoPreviewPlayerView?.player = player
        videoPreviewPlayerView?.requestLayout()
    }

    override fun detachPlayer() {
        videoPreviewPlayerView?.player = null
    }

    override fun showThumbnail(thumbnailUri: UriString?) {
        videoPreviewPlayerView?.visibility = View.GONE
        videoPreviewImageView?.visibility = View.VISIBLE
        videoPreviewImageView?.load(thumbnailUri)
    }

    override fun showVideo() {
        videoPreviewPlayerView?.visibility = View.VISIBLE
        videoPreviewImageView?.visibility = View.GONE
    }
}