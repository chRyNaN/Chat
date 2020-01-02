package com.chrynan.chat.ui.adapter.core

import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.viewmodel.ViewModel

fun <VM : ViewModel> adapterWith(builder: AdapterBuilder<VM>.() -> Unit): ManagerRecyclerViewAdapter<VM> {
    val adapterBuilder = AdapterBuilder<VM>()
    builder.invoke(adapterBuilder)
    return adapterBuilder.build()
}

class AdapterBuilder<VM : ViewModel> {

    private val adapters = mutableSetOf<BaseAdapter<*>>()

    operator fun <VM : ViewModel> BaseAdapter<VM>.unaryPlus() {
        adapters.add(this)
    }

    internal fun build(): ManagerRecyclerViewAdapter<VM> = ManagerRecyclerViewAdapter(adapters = adapters)
}