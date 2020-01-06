package com.chrynan.chat.model.contact

import com.chrynan.chat.model.core.Handle
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.Node
import com.chrynan.chat.model.core.TimeMoment

data class Account(
    override val id: ID,
    val name: String,
    val handle: Handle,
    val createdAt: TimeMoment,
    val type: String? = null,
    val image: String? = null
) : Node