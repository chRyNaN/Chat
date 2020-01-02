package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.model.ID
import com.chrynan.chat.model.UriString

data class ContactInfoHeaderItemViewModel(
    val userID: ID,
    val fullName: String,
    val imageUriString: UriString?
) : AdapterItem {

    override val uniqueAdapterId = userID.asUniqueAdapterId()
}