package com.chrynan.chat.repository

import com.chrynan.chat.feature.reaction.model.account.UserConnectionType
import com.chrynan.chat.feature.reaction.model.contact.FullContact
import com.chrynan.chat.feature.reaction.model.contact.FullContactEdge
import com.chrynan.chat.feature.reaction.model.core.ID

interface UserConnectionRepository {

    suspend fun get(id: ID): FullContact

    fun paginate(type: UserConnectionType): PaginatedRepository<FullContact, FullContactEdge>
}