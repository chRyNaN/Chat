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
import com.chrynan.chat.resources.Colors
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactListPresenter @Inject constructor(
    private val dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ContactListView,
    private val repository: BriefUserConnectionRepository,
    private val mapper: BriefContactMapper,
    private val colors: Colors
) : BasePresenter(dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    private var paginater: PaginatedRepository<BriefContact, BriefContactEdge>? = null

    @ExperimentalCoroutinesApi
    fun getContacts() {
        repository.paginate("contacts").apply {
            paginater = this
        }.subscribe(first = 10)
            .flowOn(dispatchers.io)
            .mapEachWith(mapper)
            .calculateAndDispatchDiff()
            .launchIn(this)
    }

    fun loadMore() {
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            // TODO handle exception
        }

        launch(errorHandler) {
            paginater?.load(20)
        }
    }
}