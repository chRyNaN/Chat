package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.TimeMoment

data class Place(
    override val id: ID,
    val name: String,
    val type: String,
    val description: String? = null,
    val lastUpdated: TimeMoment,
    val range: InfoTimeRange? = null,
    val address: FullAddress,
    val note: String? = null
) : Node