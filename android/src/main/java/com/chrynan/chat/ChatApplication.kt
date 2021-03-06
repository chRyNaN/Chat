package com.chrynan.chat

import com.chrynan.chat.coroutines.ApplicationCoroutineScope
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.component.ApplicationComponent
import com.chrynan.chat.di.component.DaggerApplicationComponent
import com.chrynan.logger.AndroidLogger
import com.chrynan.logger.Loggable
import com.chrynan.logger.Logger
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.EmojiProvider
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ChatApplication : DaggerApplication(),
    ApplicationCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    @Inject
    lateinit var dispatchers: CoroutineDispatchers

    @Inject
    lateinit var loggable: Loggable

    @Inject
    lateinit var emojiProvider: EmojiProvider

    override fun onCreate() {
        super.onCreate()

        Logger.loggable = AndroidLogger
        EmojiManager.install(emojiProvider)
    }

    override fun applicationInjector(): ApplicationComponent =
        DaggerApplicationComponent.builder().application(this).build()
}