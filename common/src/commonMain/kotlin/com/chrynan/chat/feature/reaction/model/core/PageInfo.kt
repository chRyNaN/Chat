package com.chrynan.chat.feature.reaction.model.core

data class PageInfo(
    val startCursor: String? = null,
    val endCursor: String? = null,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean
)