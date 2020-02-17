package com.chrynan.chat.feature.conversation.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.conversation.mapper.DecryptedMessageMapper
import com.chrynan.chat.feature.conversation.view.ConversationView
import com.chrynan.chat.interactor.GetDecryptedMessagesInteractor
import com.chrynan.chat.presenter.BasePresenter
import com.chrynan.chat.resources.DrawableIDs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ConversationPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ConversationView,
    private val drawableIDs: DrawableIDs,
    private val getDecryptedMessages: GetDecryptedMessagesInteractor,
    private val mapper: DecryptedMessageMapper,
    private val messageEditorPresenter: MessageEditorPresenter
) : BasePresenter(dispatchers = dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
    fun getInitialMessageItems() {
        getDecryptedMessages()
            .map { messages -> messages.flatMap { message -> mapper.map(message) } }
            .calculateAndDispatchDiff()
            .launchIn(this)

        messageEditorPresenter.setup()
    }

    override fun bind() {
        super.bind()

        messageEditorPresenter.bind()
    }

    override fun unbind() {
        super.unbind()

        messageEditorPresenter.unbind()
    }

    fun handleActionButtonSelected() = messageEditorPresenter.handleActionButtonSelected()

    fun handleAttachmentButtonSelected() = messageEditorPresenter.handleAttachmentButtonSelected()
}