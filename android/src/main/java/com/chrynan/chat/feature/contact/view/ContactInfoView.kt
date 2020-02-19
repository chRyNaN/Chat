package com.chrynan.chat.feature.contact.view

import com.chrynan.chat.feature.reaction.model.core.UriString
import com.chrynan.chat.view.View

interface ContactInfoView : View {

    fun showHeader(title: String, image: UriString?)
}