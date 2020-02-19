package com.chrynan.chat.repository

import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.feature.reaction.model.EmojiCategory

interface EmojiRepository {

    suspend fun getForUnicode(unicode: String): Emoji?

    suspend fun getCategories(): List<EmojiCategory>
}