package com.chrynan.chat.feature.contact.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.UserImage
import com.chrynan.chat.model.core.ID

data class ContactItemViewModel(
    val userID: ID,
    val userImage: UserImage,
    val name: String,
    val description: String? = null
) : AdapterItem {

    override val uniqueAdapterId = userID.asUniqueAdapterId()
}