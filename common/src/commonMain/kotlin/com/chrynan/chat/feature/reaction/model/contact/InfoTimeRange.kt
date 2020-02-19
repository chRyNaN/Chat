package com.chrynan.chat.feature.reaction.model.contact

import com.chrynan.chat.feature.reaction.model.core.TimeMoment

data class InfoTimeRange(
    val start: TimeMoment,
    val end: TimeMoment? = null,
    val current: Boolean = false
)