package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment
import com.chrynan.chat.model.core.UriString

class WebAddress(
    override val id: ID,
    val uriString: UriString,
    val name: String,
    val lastUpdated: TimeMoment,
    val type: String? = null,
    val description: String? = null,
    val note: String? = null
) : Node