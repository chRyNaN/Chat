package com.chrynan.chat.ui.adapter

import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.viewmodel.ViewModel

fun adapterWith(builder: AdapterBuilder.() -> Unit): ManagerRecyclerViewAdapter<ViewModel> {
    val adapterBuilder = AdapterBuilder()
    builder.invoke(adapterBuilder)
    return adapterBuilder.build()
}

class AdapterBuilder {

    private val adapters = mutableSetOf<BaseAdapter<*>>()

    operator fun <VM : ViewModel> BaseAdapter<VM>.unaryPlus() {
        adapters.add(this)
    }

    internal fun build() = ManagerRecyclerViewAdapter<ViewModel>(adapters = adapters)
}