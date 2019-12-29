package com.chrynan.chat.resources

import android.content.Context
import com.chrynan.chat.di.Inject

class ResourceProvider @Inject constructor(private val context: Context) : ResourceAccessor {

    override fun string(resourceID: ResourceID) = lazy { context.getString(resourceID) }

    override fun color(resourceID: ResourceID) = lazy { context.getColor(resourceID) }
}