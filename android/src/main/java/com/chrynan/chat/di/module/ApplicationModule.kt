package com.chrynan.chat.di.module

import com.chrynan.chat.ChatApplication
import com.chrynan.chat.coroutines.AndroidCoroutineDispatchers
import com.chrynan.chat.coroutines.ApplicationCoroutineScope
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.resources.ResourceAccessor
import com.chrynan.chat.resources.ResourceProvider
import com.chrynan.chat.utils.ApplicationContext
import dagger.Binds

@Module
internal abstract class ApplicationModule {

    @Binds
    abstract fun bindAppContext(application: ChatApplication): ApplicationContext

    @Binds
    abstract fun bindAppCoroutineScope(application: ChatApplication): ApplicationCoroutineScope

    @Binds
    abstract fun bindCoroutineDispatchers(dispatchers: AndroidCoroutineDispatchers): CoroutineDispatchers

    @Binds
    abstract fun bindResourceProvider(provider: ResourceProvider): ResourceAccessor
}