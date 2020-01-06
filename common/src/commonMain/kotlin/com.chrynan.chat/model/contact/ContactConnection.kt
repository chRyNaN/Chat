package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.PageInfo

data class ContactConnection(
    override val pageInfo: PageInfo,
    override val totalCount: Int = 0,
    override val edges: List<ContactEdge> = emptyList(),
    override val nodes: List<Contact> = emptyList()
) : Connection<Contact, ContactEdge>