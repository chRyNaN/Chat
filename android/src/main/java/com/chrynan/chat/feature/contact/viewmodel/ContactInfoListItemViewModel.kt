package com.chrynan.chat.feature.contact.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.resources.ResourceID

data class ContactInfoListItemViewModel(
    val userID: ID,
    val label: String,
    val title: String,
    val description: String? = null,
    val iconResourceID: ResourceID? = null,
    val imageUri: UriString? = null
) : AdapterItem {

    override val uniqueAdapterId = userID.asUniqueAdapterId()
}