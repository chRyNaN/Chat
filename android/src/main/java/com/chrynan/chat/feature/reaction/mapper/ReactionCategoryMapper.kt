package com.chrynan.chat.feature.reaction.mapper

import com.chrynan.chat.feature.reaction.model.EmojiCategory
import com.chrynan.chat.feature.reaction.viewmodel.ReactionCategoryItemViewModel
import com.chrynan.chat.mapper.Mapper
import javax.inject.Inject

class ReactionCategoryMapper @Inject constructor() :
    Mapper<EmojiCategory, ReactionCategoryItemViewModel> {

    override suspend fun map(model: EmojiCategory): ReactionCategoryItemViewModel =
        ReactionCategoryItemViewModel(model)
}