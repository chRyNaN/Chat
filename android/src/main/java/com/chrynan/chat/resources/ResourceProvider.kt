package com.chrynan.chat.resources

import android.content.Context
import com.chrynan.chat.di.Inject

class ResourceProvider @Inject constructor(private val context: Context) : ResourceAccessor {

    override fun string(resourceId: ResourceID) = lazy { context.getString(resourceId) }
}