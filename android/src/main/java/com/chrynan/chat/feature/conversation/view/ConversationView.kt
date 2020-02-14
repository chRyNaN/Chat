package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.feature.conversation.viewmodel.MessageListItemViewModel
import com.chrynan.chat.view.View

interface ConversationView : View {

    fun showMessageItems(items: List<MessageListItemViewModel>)
}