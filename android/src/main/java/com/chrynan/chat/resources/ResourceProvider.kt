package com.chrynan.chat.resources

import android.content.Context

abstract class ResourceProvider(contextInitializer: () -> Context) {

    private val context by lazy { contextInitializer() }

    protected fun string(resourceId: ResourceID) = lazy { context.getString(resourceId) }
}