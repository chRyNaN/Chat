package com.chrynan.chat.feature.reaction.mapper

import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.feature.reaction.viewmodel.ReactionListItemViewModel
import com.chrynan.chat.mapper.Mapper
import javax.inject.Inject

class ReactionEmojiMapper @Inject constructor() : Mapper<Emoji, ReactionListItemViewModel> {

    override suspend fun map(model: Emoji): ReactionListItemViewModel =
        ReactionListItemViewModel(model)
}