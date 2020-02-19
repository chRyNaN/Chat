package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.feature.reaction.model.core.Node
import com.chrynan.chat.feature.reaction.model.core.TimeMoment

data class FullAddress(
    override val id: ID,
    val name: String,
    val lastUpdated: TimeMoment,
    val type: String? = null,
    val description: String? = null,
    val firstLine: String? = null,
    val secondLine: String? = null,
    val apt: String? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val zipCode: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val note: String? = null,
    val range: InfoTimeRange? = null
) : Node