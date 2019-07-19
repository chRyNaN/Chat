package com.chrynan.chat.ui.adapter

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
}