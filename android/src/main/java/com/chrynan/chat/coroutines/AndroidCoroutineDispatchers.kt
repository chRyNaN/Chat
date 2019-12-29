package com.chrynan.chat.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.chrynan.chat.di.Inject

class AndroidCoroutineDispatchers @Inject constructor() : CoroutineDispatchers {

    override val main: CoroutineDispatcher = Dispatchers.Main
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}