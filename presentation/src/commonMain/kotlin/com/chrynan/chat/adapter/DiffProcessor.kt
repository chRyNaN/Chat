package com.chrynan.chat.adapter

interface DiffProcessor<VM : AdapterItem> {

    suspend fun processDiff(items: Collection<VM>): DiffResult<VM>
}