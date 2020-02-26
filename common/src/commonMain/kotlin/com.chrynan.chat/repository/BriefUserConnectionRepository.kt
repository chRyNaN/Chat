package com.chrynan.chat.repository

import com.chrynan.chat.model.account.UserConnectionType
import com.chrynan.chat.model.contact.BriefContact
import com.chrynan.chat.model.contact.BriefContactEdge
import com.chrynan.chat.model.core.ID

interface BriefUserConnectionRepository {

    suspend fun get(id: ID): BriefContact

    fun paginate(type: UserConnectionType): PaginatedRepository<BriefContact, BriefContactEdge>
}