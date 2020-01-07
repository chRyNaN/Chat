package com.chrynan.chat.model.contact

import com.chrynan.chat.model.account.AccountConnection
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.UriString

data class FullContact(
    override val id: ID,
    val imageUri: UriString? = null,
    val isPinned: Boolean = false,
    val name: PersonName,
    val info: ContactInfo,
    val accountConnection: AccountConnection? = null
) : Node