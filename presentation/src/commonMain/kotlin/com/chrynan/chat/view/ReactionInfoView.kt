package com.chrynan.chat.view

interface ReactionInfoView : View {

    fun showReactionInfo()

    fun hideReactionInfo()

    fun showReactions(reactions: List<String>)
}