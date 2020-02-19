package com.chrynan.chat.feature.reaction.model

data class ReactionCount(
    val reaction: Reaction,
    val count: Int,
    val userSelected: Boolean = false
)