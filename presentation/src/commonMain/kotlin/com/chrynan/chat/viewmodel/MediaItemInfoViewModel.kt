package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.MediaType
import com.chrynan.chat.model.Uri

class MediaItemInfoViewModel(
    val uri: Uri,
    val mediaType: MediaType,
    val name: String
) : ViewModel