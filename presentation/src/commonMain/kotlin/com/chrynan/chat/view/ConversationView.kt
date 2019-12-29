package com.chrynan.chat.view

import com.chrynan.chat.viewmodel.MessageListItemViewModel

interface ConversationView : View {

    fun showMessageItems(items: List<MessageListItemViewModel>)
}