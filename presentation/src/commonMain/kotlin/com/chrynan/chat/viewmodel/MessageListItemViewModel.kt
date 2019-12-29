package com.chrynan.chat.viewmodel

import com.chrynan.chat.model.ID

interface MessageListItemViewModel : ViewModel {

    val messageID: ID
}