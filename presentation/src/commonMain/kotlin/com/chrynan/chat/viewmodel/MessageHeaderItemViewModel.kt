package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.UriString

data class MessageHeaderItemViewModel(
    val name: String,
    val handle: String?,
    val image: UriString
) : ViewModel