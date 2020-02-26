package com.chrynan.chat.model.account

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.PageInfo

data class AccountConnection(
    override val pageInfo: PageInfo,
    override val totalCount: Int = 0,
    override val edges: List<AccountEdge> = emptyList(),
    override val nodes: List<Account> = emptyList()
) : Connection<Account, AccountEdge>