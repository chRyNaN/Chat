package com.chrynan.chat.feature.contact.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.UriString

data class ContactInfoHeaderItemViewModel(
    val userID: ID,
    val fullName: String,
    val imageUriString: UriString?
) : AdapterItem {

    override val uniqueAdapterId = userID.asUniqueAdapterId()
}