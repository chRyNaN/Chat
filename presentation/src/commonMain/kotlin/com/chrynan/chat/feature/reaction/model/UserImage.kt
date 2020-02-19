package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.feature.reaction.model.core.UriString

data class UserImage(
    val name: String,
    val backgroundColorInt: ColorInt,
    val textColorInt: ColorInt,
    val badgeColorInt: ColorInt? = null,
    val imageUri: UriString? = null
)