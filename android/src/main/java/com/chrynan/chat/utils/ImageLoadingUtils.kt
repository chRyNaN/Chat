package com.chrynan.chat.utils

import android.widget.ImageView
import coil.api.load
import com.chrynan.chat.model.core.UriString

fun ImageView.loadAndDecrypt(uri: UriString, key: String) {
    // TODO implement
    load(uri)
}