package com.chrynan.chat.feature.reaction.model.account

import com.chrynan.chat.feature.reaction.model.core.Cursor
import com.chrynan.chat.feature.reaction.model.core.Edge

data class AccountEdge(
    override val cursor: Cursor,
    override val node: Account
) : Edge<Account>