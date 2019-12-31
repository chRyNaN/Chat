package com.chrynan.chat.ui.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.adapter.AdapterItem

class BaseManagerAdapter<VM : AdapterItem>(
    private val adapters: Set<BaseAdapter<out VM>>,
    private val layoutManager: LinearLayoutManager
) : ManagerRecyclerViewAdapter<VM>(adapters = adapters) {

    private val onScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            handleOnScrolled(recyclerView, dx, dy)
        }
    }

    private var previousFirstVisibleItemPosition = -1
    private var previousLastVisibleItemPosition = -1

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(onScrollListener)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        recyclerView.removeOnScrollListener(onScrollListener)
    }

    private fun handleOnScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val firstPosition = layoutManager.findFirstVisibleItemPosition()
        val lastPosition = layoutManager.findLastVisibleItemPosition()

        if (firstPosition != previousFirstVisibleItemPosition || lastPosition != previousLastVisibleItemPosition) {
            val previousFirstItem = items.getOrNull(previousFirstVisibleItemPosition)
            val previousLastItem = items.getOrNull(previousLastVisibleItemPosition)
            val firstItem = items.getOrNull(firstPosition)
            val lastItem = items.getOrNull(lastPosition)

            val previousFirstView = layoutManager.findViewByPosition(previousFirstVisibleItemPosition)
            val previousLastView = layoutManager.findViewByPosition(previousLastVisibleItemPosition)
            val firstView = layoutManager.findViewByPosition(firstPosition)
            val lastView = layoutManager.findViewByPosition(lastPosition)

            // Top
            if (firstPosition > previousFirstVisibleItemPosition) {
                // The old item is no longer visible
                getAdapterForItem(previousFirstItem)?.exit(view = previousFirstView, item = previousFirstItem)
            } else if (firstPosition < previousFirstVisibleItemPosition) {
                // The new item is now visible
                getAdapterForItem(firstItem)?.enter(view = firstView, item = firstItem)
            }

            // Bottom
            if (lastPosition > previousLastVisibleItemPosition) {
                // The new item is now visible
                getAdapterForItem(lastItem)?.enter(view = lastView, item = lastItem)
            } else if (lastPosition < previousLastVisibleItemPosition) {
                // The old item is no longer visible
                getAdapterForItem(previousLastItem)?.exit(view = previousLastView, item = previousLastItem)
            }
        }
    }

    private fun getAdapterForItem(item: VM?) =
        if (item != null) adapters.firstOrNull { it.onHandlesItem(item) } else null
}