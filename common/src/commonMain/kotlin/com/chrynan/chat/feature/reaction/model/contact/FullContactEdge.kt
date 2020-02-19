package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.Cursor
import com.chrynan.chat.feature.reaction.model.core.Edge

data class FullContactEdge(
    override val cursor: Cursor,
    override val node: FullContact
) : Edge<FullContact>