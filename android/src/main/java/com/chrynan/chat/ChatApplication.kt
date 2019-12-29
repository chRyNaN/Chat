package com.chrynan.chat

import com.chrynan.chat.coroutines.ApplicationCoroutineScope
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.di.component.ApplicationComponent
import com.chrynan.chat.di.component.DaggerApplicationComponent
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class ChatApplication : DaggerApplication(),
    ApplicationCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    @Inject
    lateinit var dispatchers: CoroutineDispatchers

    override fun applicationInjector(): ApplicationComponent =
        DaggerApplicationComponent.builder().application(this).build()
}