package com.chrynan.chat.feature.contact.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.mapEachWith
import com.chrynan.chat.feature.contact.mapper.BriefContactMapper
import com.chrynan.chat.feature.contact.view.ContactListView
import com.chrynan.chat.feature.reaction.model.contact.BriefContact
import com.chrynan.chat.feature.reaction.model.contact.BriefContactEdge
import com.chrynan.chat.presenter.BasePresenter
import com.chrynan.chat.repository.BriefUserConnectionRepository
import com.chrynan.chat.repository.PaginatedRepository
import com.chrynan.chat.utils.calculateAndDispatchDiff
import com.chrynan.logger.Loggable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactListPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ContactListView,
    private val repository: BriefUserConnectionRepository,
    private val mapper: BriefContactMapper,
    private val logger: Loggable
) : BasePresenter(dispatchers) {

    private val paginater: PaginatedRepository<BriefContact, BriefContactEdge> by lazy {
        repository.paginate("contacts")
    }

    @ExperimentalCoroutinesApi
    fun getContacts() {
        paginater.subscribe(first = 10)
            .flowOn(dispatchers.io)
            .mapEachWith(mapper)
            .calculateAndDispatchDiff(adapterItemHandler)
            .launchIn(this)
    }

    fun loadMore() {
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            logger.logError(message = "Error loading more contacts.", throwable = throwable)
        }

        launch(errorHandler) {
            withContext(dispatchers.io) { paginater.load(20) }

            view.toggleLoading(isLoading = false)
        }
    }
}