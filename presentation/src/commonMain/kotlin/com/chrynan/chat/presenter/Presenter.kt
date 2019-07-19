package com.chrynan.chat.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.PresenterCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class Presenter(private val dispatchers: CoroutineDispatchers) : PresenterCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    var isBound = false
        private set

    private lateinit var job: Job

    fun bind() {
        job = SupervisorJob()
        isBound = true
    }

    fun unbind() {
        job.cancel()
        isBound = false
    }
}