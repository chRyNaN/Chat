package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.resources.ResourceID

interface Emoji {

    val unicode: String
    val variants: List<Emoji>
    val isDuplicate: Boolean
    val isBase: Boolean
    val resourceID: ResourceID
    val base: Emoji
}