package com.chrynan.chat.feature.reaction.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.chrynan.chat.resources.ResourceID

sealed class AndroidEmoji : Emoji {

    abstract fun drawable(context: Context): Drawable

    data class Base(
        private val libraryEmoji: com.vanniktech.emoji.emoji.Emoji,
        private val variantMapper: (com.vanniktech.emoji.emoji.Emoji) -> Variant
    ) : AndroidEmoji() {

        override val unicode: String
            get() = libraryEmoji.unicode

        override val variants: List<Variant>
            get() = libraryEmoji.variants.map { variantMapper(it) }

        override val isDuplicate: Boolean
            get() = libraryEmoji.isDuplicate

        override val resourceID: ResourceID
            get() = libraryEmoji.resource

        override val isBase = true

        override val base: Emoji = this

        override fun drawable(context: Context): Drawable = libraryEmoji.getDrawable(context)
    }

    data class Variant(private val libraryEmoji: com.vanniktech.emoji.emoji.Emoji) :
        AndroidEmoji() {

        override val unicode: String
            get() = libraryEmoji.unicode

        override val isDuplicate: Boolean
            get() = libraryEmoji.isDuplicate

        override val resourceID: ResourceID
            get() = libraryEmoji.resource

        override val isBase = false

        override val variants: List<Emoji> = emptyList()

        override val base: Emoji = Base(
            libraryEmoji = libraryEmoji.base,
            variantMapper = { it.toVariantEmoji() })

        override fun drawable(context: Context): Drawable = libraryEmoji.getDrawable(context)
    }
}

fun com.vanniktech.emoji.emoji.Emoji.toBaseEmoji(): AndroidEmoji.Base =
    AndroidEmoji.Base(
        libraryEmoji = this,
        variantMapper = { it.toVariantEmoji() }
    )

fun com.vanniktech.emoji.emoji.Emoji.toVariantEmoji(): AndroidEmoji.Variant =
    AndroidEmoji.Variant(libraryEmoji = this)

fun ImageView.load(emoji: Emoji) {
    if (emoji is AndroidEmoji) {
        setImageDrawable(emoji.drawable(context))
    } else {
        setImageResource(emoji.resourceID)
    }
}