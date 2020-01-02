package com.chrynan.chat.ui.adapter

import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.chat.coroutines.AdapterCoroutineScope
import com.chrynan.chat.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseAdapter<VM : ViewModel>(private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main) :
    AnotherAdapter<VM>(),
    AdapterCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + mainDispatcher

    private val job = SupervisorJob()

    fun enter(view: View?, item: Any?) {
        castOrNull(item)?.let { onEnter(view, it) }
    }

    fun exit(view: View?, item: Any?) {
        castOrNull(item)?.let { onExit(view, it) }
    }

    fun recycle(view: View?, item: Any?) {
        castOrNull(item)?.let { onRecycled(view, it) }
    }

    @CallSuper
    open fun onEnter(view: View?, item: VM?) {

    }

    @CallSuper
    open fun onExit(view: View?, item: VM?) {
        job.cancel() // TODO test this works as intended
    }

    @CallSuper
    open fun onRecycled(view: View?, item: VM?) {

    }

    @CallSuper
    open fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {

    }

    @Suppress("UNCHECKED_CAST")
    private fun castOrNull(item: Any?): VM? =
        try {
            item as? VM
        } catch (e: Exception) {
            null
        }
}