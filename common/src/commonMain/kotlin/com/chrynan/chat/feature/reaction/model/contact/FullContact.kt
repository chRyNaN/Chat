package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.account.AccountConnection
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.UriString

data class FullContact(
    override val id: ID,
    val imageUri: UriString? = null,
    val isPinned: Boolean = false,
    val name: PersonName,
    val info: ContactInfo,
    val accountConnection: AccountConnection? = null
) : Node