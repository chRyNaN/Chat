package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.TimeMoment

data class InfoTimeRange(
    val start: TimeMoment,
    val end: TimeMoment? = null,
    val current: Boolean = false
)