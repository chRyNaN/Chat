package com.chrynan.chat.source

import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.feature.reaction.model.EmojiCategory
import com.chrynan.chat.feature.reaction.model.toBaseEmoji
import com.chrynan.chat.repository.EmojiRepository
import com.vanniktech.emoji.EmojiProvider
import javax.inject.Inject

class EmojiSource @Inject constructor(private val emojiProvider: EmojiProvider) : EmojiRepository {

    override suspend fun getForUnicode(unicode: String): Emoji? {
        getCategories().forEach { category ->
            val emoji = category.emojis.firstOrNull { unicode == it.unicode }

            if (emoji != null) return emoji
        }

        return null
    }

    override suspend fun getCategories(): List<EmojiCategory> =
        emojiProvider.categories.map { category ->
            EmojiCategory(
                emojis = category.emojis.map { it.toBaseEmoji() },
                icon = category.icon
            )
        }
}