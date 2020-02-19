package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.resources.ResourceID

data class EmojiCategory(
    val emojis: List<Emoji> = emptyList(),
    val icon: ResourceID
)