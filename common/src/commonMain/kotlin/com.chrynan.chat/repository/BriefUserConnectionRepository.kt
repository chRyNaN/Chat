package com.chrynan.chat.repository

import com.chrynan.chat.feature.reaction.model.account.UserConnectionType
import com.chrynan.chat.feature.reaction.model.contact.BriefContact
import com.chrynan.chat.feature.reaction.model.contact.BriefContactEdge
import com.chrynan.chat.feature.reaction.model.core.ID

interface BriefUserConnectionRepository {

    suspend fun get(id: ID): BriefContact

    fun paginate(type: UserConnectionType): PaginatedRepository<BriefContact, BriefContactEdge>
}