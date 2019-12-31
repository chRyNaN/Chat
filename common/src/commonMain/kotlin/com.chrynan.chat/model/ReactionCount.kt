package com.chrynan.chat.model

data class ReactionCount(
    val content: Reaction,
    val count: Int,
    val userSelected: Boolean = false
)