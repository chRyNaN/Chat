package com.chrynan.chat.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.resources.DrawableIDs
import com.chrynan.chat.view.ConversationView
import com.chrynan.chat.viewmodel.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn

class ConversationPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ConversationView,
    private val drawableIDs: DrawableIDs
) : BasePresenter(dispatchers = dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
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
                image = null,
                date = "11:30pm"
            ),
            MessageTextItemViewModel(
                messageID = "",
                text = "A sample of a text message. This is just going to be random text."
            ),
            MessageStatusItemViewModel(
                messageID = "",
                status = "Seen",
                image = drawableIDs.icSent
            ),
            MessageThreadItemViewModel(
                messageID = "",
                messageCount = "10 replies"
            )
        )

        flowOf(items)
            .calculateAndDispatchDiff()
            .launchIn(this)
    }
}