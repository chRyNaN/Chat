package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.UriString

data class BriefContact(
    override val id: ID,
    val imageUri: UriString? = null,
    val isPinned: Boolean = false,
    val name: PersonName
) : Node