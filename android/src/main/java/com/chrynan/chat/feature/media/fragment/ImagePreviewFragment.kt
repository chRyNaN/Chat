package com.chrynan.chat.feature.media.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.feature.media.parcel.getImagePreviewViewModel
import com.chrynan.chat.feature.media.parcel.putImagePreviewViewModel
import com.chrynan.chat.feature.media.presenter.ImagePreviewPresenter
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import com.chrynan.chat.feature.media.util.ToggleSystemUITouchListener
import com.chrynan.chat.feature.media.view.ImagePreviewView
import com.chrynan.chat.feature.media.viewmodel.ImagePreviewItemViewModel
import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.utils.loadAndDecrypt
import kotlinx.android.synthetic.main.fragment_image_preview.*
import javax.inject.Inject

class ImagePreviewFragment : BaseFragment(),
    ImagePreviewView {

    companion object {

        private const val KEY_IMAGE_MODEL = "KeyImagePreviewFragmentImagePreviewModel"

        fun newInstance(model: ImagePreviewItemViewModel) = ImagePreviewFragment().apply {
            arguments = Bundle().apply {
                putImagePreviewViewModel(KEY_IMAGE_MODEL, model)
            }
        }
    }

    @Inject
    override lateinit var presenter: ImagePreviewPresenter

    @Inject
    lateinit var toggleSystemUIListener: ToggleSystemUIListener

    private val model by lazy { arguments?.getImagePreviewViewModel(KEY_IMAGE_MODEL)!! }

    private val photoTapListener by lazy { ToggleSystemUITouchListener(toggleSystemUIListener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_image_preview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagePreviewImageView?.setOnPhotoTapListener(photoTapListener)
        imagePreviewImageView?.setOnOutsidePhotoTapListener(photoTapListener)

        presenter.setup(model = model)
    }

    override fun showImage(uri: UriString, key: String?) {
        if (key != null) {
            imagePreviewImageView?.loadAndDecrypt(uri, key)
        } else {
            imagePreviewImageView?.load(uri)
        }
    }
}