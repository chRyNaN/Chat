package com.chrynan.chat.model.account

import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.Edge

data class AccountEdge(
    override val cursor: Cursor,
    override val node: Account
) : Edge<Account>