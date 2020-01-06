package com.chrynan.chat.model

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.UriString

data class User(
    val userID: ID,
    val accountID: ID,
    val name: String,
    val handle: String,
    val imageUri: UriString? = null,
    val isOnline: Boolean = false
) : Node {

    override val id = userID
}