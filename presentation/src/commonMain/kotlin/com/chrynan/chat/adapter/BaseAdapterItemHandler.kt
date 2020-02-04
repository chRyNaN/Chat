package com.chrynan.chat.adapter

import com.chrynan.aaaah.DiffDispatcher
import com.chrynan.aaaah.DiffProcessor
import com.chrynan.aaaah.DiffResult
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class BaseAdapterItemHandler<VM : AdapterItem> @Inject constructor(
    private val diffProcessor: DiffProcessor<VM>,
    private val diffDispatcher: DiffDispatcher<VM>,
    private val coroutineDispatchers: CoroutineDispatchers
) : AdapterItemHandler<VM> {

    @ExperimentalCoroutinesApi
    override fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>> =
        map(diffProcessor::processDiff)
            .flowOn(coroutineDispatchers.io)
            .onEach { diffDispatcher.dispatchDiff(it) }
            .flowOn(coroutineDispatchers.main)
}