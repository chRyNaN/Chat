package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.Edge

data class ContactEdge(
    override val cursor: Cursor,
    override val node: Contact
) : Edge<Contact>