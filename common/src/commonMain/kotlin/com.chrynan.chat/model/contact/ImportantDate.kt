package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment

data class ImportantDate(
    override val id: ID,
    val name: String,
    val type: String? = null,
    val description: String? = null,
    val date: TimeMoment,
    val lastUpdated: TimeMoment,
    val notify: Boolean = false,
    val note: String? = null
) : Node