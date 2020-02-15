package com.chrynan.chat.feature.media.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.feature.media.parcel.getMediaItemViewModel
import com.chrynan.chat.feature.media.parcel.putMediaItemViewModel
import com.chrynan.chat.feature.media.presenter.AudioPreviewPresenter
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import com.chrynan.chat.feature.media.util.ToggleSystemUITouchListener
import com.chrynan.chat.feature.media.view.AudioPreviewView
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.ui.fragment.BaseFragment
import javax.inject.Inject

class AudioPreviewFragment : BaseFragment(),
    AudioPreviewView {

    companion object {

        private const val KEY_MEDIA_ITEM_MODEL = "KeyAudioPreviewFragmentMediaItemViewModel"

        fun newInstance(model: MediaItemViewModel) = AudioPreviewFragment().apply {
            arguments = Bundle().apply {
                putMediaItemViewModel(KEY_MEDIA_ITEM_MODEL, model)
            }
        }
    }

    @Inject
    override lateinit var presenter: AudioPreviewPresenter

    @Inject
    lateinit var toggleSystemUIListener: ToggleSystemUIListener

    private val model by lazy { arguments?.getMediaItemViewModel(KEY_MEDIA_ITEM_MODEL)!! }

    private val systemUITouchListener by lazy { ToggleSystemUITouchListener(toggleSystemUIListener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_audio_preview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setup(model = model)
    }
}