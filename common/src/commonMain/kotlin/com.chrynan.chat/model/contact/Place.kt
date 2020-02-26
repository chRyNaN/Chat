package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment

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