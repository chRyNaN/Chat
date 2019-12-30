package com.chrynan.chat.adapter

import kotlinx.coroutines.flow.Flow

interface AdapterItemHandler<VM : AdapterItem> {

    fun Flow<Collection<VM>>.calculateAndDispatchDiff(): Flow<DiffResult<VM>>
}