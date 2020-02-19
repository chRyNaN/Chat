package com.chrynan.chat.feature.reaction.model.account

import com.chrynan.chat.feature.reaction.model.contact.FullContactConnection
import com.chrynan.chat.feature.reaction.model.contact.ContactInfo
import com.chrynan.chat.feature.reaction.model.contact.PersonName
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.UriString

data class User(
    override val id: ID,
    val name: PersonName,
    val imageUri: UriString? = null,
    val info: ContactInfo = ContactInfo(),
    val accountConnection: AccountConnection? = null,
    val contactConnection: FullContactConnection? = null,
    val pinnedContactConnection: FullContactConnection? = null
) : Node