package com.chrynan.chat.model

data class UserImage(
    val name: String,
    val backgroundColorInt: ColorInt,
    val textColorInt: ColorInt,
    val badgeColorInt: ColorInt? = null,
    val imageUri: UriString? = null
)