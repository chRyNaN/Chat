package com.chrynan.chat.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.ViewType
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.viewmodel.ViewModel

abstract class BaseHorizontalAdapter<VM : ViewModel> {

    abstract val startPositionViewType: ViewType

    abstract val endPositionViewType: ViewType

    abstract fun onHandlesItem(item: Any, position: HorizontalPosition): Boolean

    abstract fun onCreateView(
        parent: ViewGroup,
        viewType: ViewType,
        position: HorizontalPosition
    ): View

    abstract fun onBind(view: View, item: VM, position: HorizontalPosition)

    fun startAdapter(): BaseAdapter<VM> =
        HorizontalPositionAdapter(
            position = HorizontalPosition.START,
            adapter = this
        )

    fun endAdapter(): BaseAdapter<VM> =
        HorizontalPositionAdapter(
            position = HorizontalPosition.END,
            adapter = this
        )

    private class HorizontalPositionAdapter<VM : ViewModel>(
        private val position: HorizontalPosition,
        private val adapter: BaseHorizontalAdapter<VM>
    ) : BaseAdapter<VM>() {

        override val viewType: ViewType =
            if (position == HorizontalPosition.START) adapter.startPositionViewType else adapter.endPositionViewType

        override fun onHandlesItem(item: Any) = adapter.onHandlesItem(item, position)

        override fun onCreateView(parent: ViewGroup, viewType: ViewType) =
            adapter.onCreateView(parent, viewType, position)

        override fun onBindItem(view: View, item: VM) = adapter.onBind(view, item, position)
    }
}