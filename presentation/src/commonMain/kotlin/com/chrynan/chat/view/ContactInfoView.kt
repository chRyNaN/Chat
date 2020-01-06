package com.chrynan.chat.view

import com.chrynan.chat.model.core.UriString

interface ContactInfoView : View {

    fun showHeader(title: String, image: UriString?)
}