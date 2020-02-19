package com.chrynan.chat.feature.reaction.model.account

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.TimeMoment

data class Account(
    override val id: ID,
    val name: String,
    val handle: Handle,
    val createdAt: TimeMoment,
    val type: String? = null,
    val image: String? = null
) : Node