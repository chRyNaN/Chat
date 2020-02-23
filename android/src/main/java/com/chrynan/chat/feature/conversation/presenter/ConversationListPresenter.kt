package com.chrynan.chat.feature.conversation.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.flowOf
import com.chrynan.chat.feature.conversation.view.ConversationListView
import com.chrynan.chat.feature.conversation.viewmodel.ConversationListItemViewModel
import com.chrynan.chat.presenter.BasePresenter
import com.chrynan.chat.utils.calculateAndDispatchDiff
import com.chrynan.logger.Loggable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConversationListPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: ConversationListView,
    private val adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val logger: Loggable
) : BasePresenter(dispatchers) {

    fun loadItems() {
        flowOf {
            listOf(
                ConversationListItemViewModel(
                    conversationId = "",
                    title = "Title",
                    description = "Description",
                    userImage = null,
                    formattedDateTime = "Time",
                    showNewItemBadge = true
                ),
                ConversationListItemViewModel(
                    conversationId = "",
                    title = "Title Two",
                    description = "Description Two",
                    userImage = null,
                    formattedDateTime = "Time Two"
                )
            )
        }
            .calculateAndDispatchDiff(adapterItemHandler)
            .launchIn(this)
    }

    fun loadMore() {
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            logger.logError(
                message = "Error loading more Conversation items.",
                throwable = throwable
            )
        }

        launch(errorHandler) {
            view.toggleLoading(isLoading = false)
        }
    }
}