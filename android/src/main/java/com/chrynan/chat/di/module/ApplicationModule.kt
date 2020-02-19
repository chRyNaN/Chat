package com.chrynan.chat.di.module

import com.chrynan.chat.ChatApplication
import com.chrynan.chat.coroutines.AndroidCoroutineDispatchers
import com.chrynan.chat.coroutines.ApplicationCoroutineScope
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.resources.*
import com.chrynan.chat.utils.ApplicationContext
import com.chrynan.chat.utils.Logger
import com.chrynan.logger.Loggable
import com.vanniktech.emoji.EmojiProvider
import com.vanniktech.emoji.google.GoogleEmojiProvider
import dagger.Binds
import dagger.Provides

@Module
internal abstract class ApplicationModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideEmojiProvider(): EmojiProvider = GoogleEmojiProvider()
    }

    @Binds
    abstract fun bindAppContext(application: ChatApplication): ApplicationContext

    @Binds
    abstract fun bindAppCoroutineScope(application: ChatApplication): ApplicationCoroutineScope

    @Binds
    abstract fun bindCoroutineDispatchers(dispatchers: AndroidCoroutineDispatchers): CoroutineDispatchers

    @Binds
    abstract fun bindResourceProvider(provider: ResourceProvider): ResourceAccessor

    @Binds
    abstract fun bindStrings(provider: StringProvider): Strings

    @Binds
    abstract fun bindColors(provider: ColorProvider): Colors

    @Binds
    abstract fun bindDrawableIDs(provider: DrawableIDProvider): DrawableIDs

    @Binds
    abstract fun bindLogger(logger: Logger): Loggable
}