package com.chrynan.chat.feature.reaction.model.contact

data class PersonName(
    val firstName: String,
    val fullName: String,
    val namePrefix: String? = null,
    val nameSuffix: String? = null,
    val middleName: String? = null,
    val lastName: String? = null,
    val nickname: String? = null,
    val phoneticName: String? = null
)