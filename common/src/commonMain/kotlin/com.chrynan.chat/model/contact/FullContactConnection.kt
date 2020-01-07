package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.PageInfo

data class FullContactConnection(
    override val pageInfo: PageInfo,
    override val totalCount: Int = 0,
    override val edges: List<FullContactEdge> = emptyList(),
    override val nodes: List<FullContact> = emptyList()
) : Connection<FullContact, FullContactEdge>