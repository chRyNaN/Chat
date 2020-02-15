package com.chrynan.chat.feature.media.parcel

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.feature.media.viewmodel.ParcelableImagePreviewModel
import kotlinx.android.parcel.Parceler

object MediaItemViewModelParceler : Parceler<MediaItemViewModel> {

    override fun create(parcel: Parcel): MediaItemViewModel {
        val imageUri = parcel.readString()
        val key = parcel.readString()

        return MediaItemViewModel(
            uri = imageUri!!,
            key = key
        )
    }

    override fun MediaItemViewModel.write(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(key)
    }
}

fun Intent.putMediaItemViewModelExtra(key: String, model: MediaItemViewModel): Intent =
    putExtra(
        key,
        ParcelableImagePreviewModel(
            model = model
        )
    )

fun Intent.getMediaItemViewModel(key: String): MediaItemViewModel? =
    getParcelableExtra<ParcelableImagePreviewModel>(key)?.model

fun Bundle.putMediaItemViewModel(key: String, model: MediaItemViewModel) =
    putParcelable(
        key,
        ParcelableImagePreviewModel(
            model = model
        )
    )

fun Bundle.getMediaItemViewModel(key: String) =
    getParcelable<ParcelableImagePreviewModel>(key)?.model