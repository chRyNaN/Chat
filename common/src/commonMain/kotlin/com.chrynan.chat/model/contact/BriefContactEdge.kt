package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.Edge

data class BriefContactEdge(
    override val cursor: Cursor,
    override val node: BriefContact
) : Edge<BriefContact>