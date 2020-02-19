package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.UriString

data class MessageUser(
    val userID: ID,
    val accountID: ID,
    val name: String,
    val handle: String,
    val imageUri: UriString? = null,
    val isOnline: Boolean = false
) : Node {

    override val id = userID
}