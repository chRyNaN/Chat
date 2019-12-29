package com.chrynan.chat.resources

interface ResourceAccessor {

    fun string(resourceId: ResourceID): Lazy<String>
}