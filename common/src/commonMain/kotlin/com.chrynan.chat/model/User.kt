package com.chrynan.chat.model

data class User(
    val userID: ID,
    val accountID: ID,
    val name: String,
    val handle: String,
    val imageUri: UriString? = null
) : Node {

    override val id = userID
}