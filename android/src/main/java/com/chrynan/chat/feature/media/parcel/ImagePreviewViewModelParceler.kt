package com.chrynan.chat.feature.media.parcel

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import com.chrynan.chat.feature.media.viewmodel.ParcelableImagePreviewModel
import com.chrynan.chat.feature.media.viewmodel.ImagePreviewItemViewModel
import kotlinx.android.parcel.Parceler

object ImagePreviewViewModelParceler : Parceler<ImagePreviewItemViewModel> {

    override fun create(parcel: Parcel): ImagePreviewItemViewModel {
        val imageUri = parcel.readString()
        val key = parcel.readString()

        return ImagePreviewItemViewModel(
            imageUri = imageUri!!,
            key = key
        )
    }

    override fun ImagePreviewItemViewModel.write(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUri)
        parcel.writeString(key)
    }
}

fun Intent.putImagePreviewViewModelExtra(key: String, model: ImagePreviewItemViewModel): Intent =
    putExtra(key,
        ParcelableImagePreviewModel(
            model = model
        )
    )

fun Intent.getImagePreviewViewModel(key: String): ImagePreviewItemViewModel? =
    getParcelableExtra<ParcelableImagePreviewModel>(key)?.model

fun Bundle.putImagePreviewViewModel(key: String, model: ImagePreviewItemViewModel) =
    putParcelable(key,
        ParcelableImagePreviewModel(
            model = model
        )
    )

fun Bundle.getImagePreviewViewModel(key: String) =
    getParcelable<ParcelableImagePreviewModel>(key)?.model