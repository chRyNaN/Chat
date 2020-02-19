package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.Cursor
import com.chrynan.chat.feature.reaction.model.core.Edge

data class BriefContactEdge(
    override val cursor: Cursor,
    override val node: BriefContact
) : Edge<BriefContact>