package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.view.View

interface ConversationListView : View {

    fun toggleLoading(isLoading: Boolean)
}