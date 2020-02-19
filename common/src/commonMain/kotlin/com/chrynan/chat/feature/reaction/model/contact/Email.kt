package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.TimeMoment

data class Email(
    override val id: ID,
    val email: String,
    val name: String,
    val type: String? = null,
    val note: String? = null,
    val description: String? = null,
    val lastUpdated: TimeMoment,
    val range: InfoTimeRange? = null
) : Node