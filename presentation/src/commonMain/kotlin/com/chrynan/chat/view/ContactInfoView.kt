package com.chrynan.chat.view

import com.chrynan.chat.model.UriString

interface ContactInfoView : View {

    fun showHeader(title: String, image: UriString?)
}