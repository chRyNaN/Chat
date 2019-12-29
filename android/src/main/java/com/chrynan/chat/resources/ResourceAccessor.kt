package com.chrynan.chat.resources

import com.chrynan.chat.model.ColorInt

interface ResourceAccessor {

    fun string(resourceID: ResourceID): Lazy<String>

    fun color(resourceID: ResourceID): Lazy<ColorInt>
}