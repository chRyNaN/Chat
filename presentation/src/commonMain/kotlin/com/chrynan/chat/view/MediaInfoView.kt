package com.chrynan.chat.view

import com.chrynan.chat.viewmodel.MediaItemInfoViewModel

interface MediaInfoView : View {

    fun showMedia(mediaItems: List<MediaItemInfoViewModel>)

    fun hideMedia()
}