package com.chrynan.chat.adapter

interface DiffDispatcher<VM : AdapterItem> {

    suspend fun dispatchDiff(diff: DiffResult<VM>)
}