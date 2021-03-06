package com.chrynan.chat.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.PresenterCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter(protected val dispatchers: CoroutineDispatchers) : Presenter,
    PresenterCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    var isBound = false
        private set

    private lateinit var job: Job

    override fun bind() {
        if (!isBound) onBind()
    }

    override fun unbind() {
        if (isBound) onUnbind()
    }

    protected open fun onBind() {
        job = SupervisorJob()
        isBound = true
    }

    protected open fun onUnbind() {
        job.cancel()
        isBound = false
    }
}