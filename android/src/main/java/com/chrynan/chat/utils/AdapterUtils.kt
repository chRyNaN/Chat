package com.chrynan.chat.utils

import com.chrynan.aaaah.DiffResult
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import kotlinx.coroutines.flow.Flow

fun <VM : AdapterItem> Flow<Collection<VM>>.calculateAndDispatchDiff(itemHandler: AdapterItemHandler<VM>): Flow<DiffResult<VM>> =
    itemHandler.run {
        calculateAndDispatchDiff()
    }