package com.chrynan.chat.model

data class PageInfo(
    val startCursor: String? = null,
    val endCursor: String? = null,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean
)