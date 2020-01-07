package com.chrynan.chat.model.account

import com.chrynan.chat.model.contact.FullContactConnection
import com.chrynan.chat.model.contact.ContactInfo
import com.chrynan.chat.model.contact.PersonName
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.UriString

data class User(
    override val id: ID,
    val name: PersonName,
    val imageUri: UriString? = null,
    val info: ContactInfo = ContactInfo(),
    val accountConnection: AccountConnection? = null,
    val contactConnection: FullContactConnection? = null,
    val pinnedContactConnection: FullContactConnection? = null
) : Node