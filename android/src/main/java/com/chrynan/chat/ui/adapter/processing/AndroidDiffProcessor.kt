package com.chrynan.chat.ui.adapter.processing

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.DiffProcessor
import com.chrynan.chat.di.Inject

class AndroidDiffProcessor<VM : AdapterItem> @Inject constructor() : DiffProcessor<VM> {

    override suspend fun processDiff(items: Collection<VM>): AndroidDiffResult<VM> {
        TODO("Need to fix issues with the AAAAH Library and JitPack for this to work")
    }
}