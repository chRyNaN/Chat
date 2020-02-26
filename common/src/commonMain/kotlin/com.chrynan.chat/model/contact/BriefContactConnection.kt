package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.PageInfo

data class BriefContactConnection(
    override val pageInfo: PageInfo,
    override val totalCount: Int = 0,
    override val edges: List<BriefContactEdge> = emptyList(),
    override val nodes: List<BriefContact> = emptyList()
) : Connection<BriefContact, BriefContactEdge>