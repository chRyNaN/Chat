package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.UriString

data class BriefContact(
    override val id: ID,
    val imageUri: UriString? = null,
    val isPinned: Boolean = false,
    val name: PersonName
) : Node