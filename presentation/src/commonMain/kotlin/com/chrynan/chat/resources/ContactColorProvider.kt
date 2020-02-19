package com.chrynan.chat.resources

import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.reaction.model.ColorInt

class ContactColorProvider @Inject constructor(private val colors: Colors) {

    private val contactColors by lazy {
        listOf(
            colors.accentOne,
            colors.accentTwo,
            colors.accentThree,
            colors.accentFour,
            colors.accentFive,
            colors.accentSix
        )
    }

    fun getFor(contact: Any): ColorInt = contactColors[contact.hashCode() % contactColors.size]
}