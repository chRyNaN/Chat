package com.chrynan.chat.feature.reaction.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.Emoji

data class ReactionListItemViewModel(
    val emoji: Emoji
) : AdapterItem {

    override val uniqueAdapterId = emoji.unicode.asUniqueAdapterId()
}