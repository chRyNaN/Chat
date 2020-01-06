package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.model.core.ID

data class ContactInfoActionItemViewModel(
    val userID: ID,
    val defaultHandle: String? = null,
    val defaultPhoneNumber: String? = null,
    val defaultEmail: String? = null
) : AdapterItem {

    override val uniqueAdapterId = userID.asUniqueAdapterId()
}