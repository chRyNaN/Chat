package com.chrynan.chat.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.view.ConversationView
import com.chrynan.chat.viewmodel.*

class ConversationPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: ConversationView
) : BasePresenter(dispatchers = dispatchers) {

    fun getInitialMessageItems() {
        val items = listOf(
            MessageHeaderDateItemViewModel(
                messageID = "",
                date = "Today"
            ),
            MessageHeaderItemViewModel(
                messageID = "",
                name = "Chris",
                handle = "chris@chrynan.codes",
                image = null
            ),
            MessageTextItemViewModel(
                messageID = "",
                text = "A sample of a text message. This is just going to be random text."
            ),
            MessageThreadItemViewModel(
                messageID = "",
                messageCount = null
            ),
            MessageStatusItemViewModel(
                messageID = "",
                status = "Seen",
                image = 0
            )
        )

        view.showMessageItems(items)
    }
}