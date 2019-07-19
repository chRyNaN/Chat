package com.chrynan.chat.viewmodel

data class ReactionInfoViewModel(
    val showReactions: Boolean,
    val reactions: List<String>
) : ViewModel