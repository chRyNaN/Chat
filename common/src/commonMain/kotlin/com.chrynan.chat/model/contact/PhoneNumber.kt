package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment

data class PhoneNumber(
    override val id: ID,
    val number: String,
    val formattedNumber: String,
    val name: String,
    val type: String? = null,
    val description: String? = null,
    val lastUpdated: TimeMoment,
    val range: InfoTimeRange? = null,
    val note: String? = null
) : Node