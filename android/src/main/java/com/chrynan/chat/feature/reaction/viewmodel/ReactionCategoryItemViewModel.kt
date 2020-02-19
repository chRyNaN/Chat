package com.chrynan.chat.feature.reaction.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.EmojiCategory

data class ReactionCategoryItemViewModel(
    val category: EmojiCategory,
    val isSelected: Boolean = false
) : AdapterItem {

    override val uniqueAdapterId = category.icon.asUniqueAdapterId()
}