package com.chrynan.chat.ui.adapter.processing

import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.DiffDispatcher
import com.chrynan.chat.adapter.DiffResult
import com.chrynan.chat.di.Inject

class AndroidDiffDispatcher<VM : AdapterItem> @Inject constructor(private val listener: ItemListUpdater<VM>) :
    DiffDispatcher<VM> {

    override suspend fun dispatchDiff(diff: DiffResult<VM>) {
        listener.items = diff.items
        // TODO NOTE that this might not call notifyDataSetChanged() possibly causing issues
        if (diff is AndroidDiffResult) {
            diff.diffUtilResult.dispatchUpdatesTo(listener)
        } else if (listener is ManagerRecyclerViewAdapter) {
            listener.notifyDataSetChanged()
        }
    }
}