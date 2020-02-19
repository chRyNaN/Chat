package com.chrynan.chat.resources

import com.chrynan.chat.feature.reaction.model.ColorInt

interface ResourceAccessor {

    fun string(resourceID: ResourceID): Lazy<String>

    fun color(resourceID: ResourceID): Lazy<ColorInt>
}