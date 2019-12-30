package com.chrynan.chat.ui.adapter.processing

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.DiffProcessor
import com.chrynan.chat.di.Inject

class AndroidDiffProcessor<VM : AdapterItem> @Inject constructor(private val processor: com.chrynan.aaaah.DiffProcessor<VM>) :
    DiffProcessor<VM> {

    override suspend fun processDiff(items: Collection<VM>): AndroidDiffResult<VM> {
        val result = processor.calculateDiff(items.toList())

        return AndroidDiffResult(
            items = processor.currentList,
            diffUtilResult = result
        )
    }
}