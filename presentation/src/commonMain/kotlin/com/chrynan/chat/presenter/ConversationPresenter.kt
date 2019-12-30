package com.chrynan.chat.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.interactor.GetDecryptedMessagesInteractor
import com.chrynan.chat.mapper.DecryptedMessageMapper
import com.chrynan.chat.resources.DrawableIDs
import com.chrynan.chat.view.ConversationView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class ConversationPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ConversationView,
    private val drawableIDs: DrawableIDs,
    private val getDecryptedMessages: GetDecryptedMessagesInteractor,
    private val mapper: DecryptedMessageMapper
) : BasePresenter(dispatchers = dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
    fun getInitialMessageItems() {
        getDecryptedMessages()
            .map { messages -> messages.flatMap { message -> mapper.map(message) } }
            .calculateAndDispatchDiff()
            .launchIn(this)
    }
}