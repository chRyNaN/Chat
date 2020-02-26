package com.chrynan.chat.model

import com.chrynan.chat.model.Reaction

data class ReactionCount(
    val reaction: Reaction,
    val count: Int,
    val userSelected: Boolean = false
)