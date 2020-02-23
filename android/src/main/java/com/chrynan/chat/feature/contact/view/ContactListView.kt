package com.chrynan.chat.feature.contact.view

import com.chrynan.chat.view.View

interface ContactListView : View {

    fun toggleLoading(isLoading: Boolean)
}