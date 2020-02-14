package com.chrynan.chat.feature.media.viewmodel

import android.os.Parcelable
import com.chrynan.chat.feature.media.parcel.ImagePreviewViewModelParceler
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.WriteWith

@Parcelize
class ParcelableImagePreviewModel(
    val model: @WriteWith<ImagePreviewViewModelParceler> ImagePreviewItemViewModel
) : Parcelable