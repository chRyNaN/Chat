package com.chrynan.chat.repository

import com.chrynan.chat.model.account.UserConnectionType
import com.chrynan.chat.model.contact.BriefContact
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.repository.paginate.BriefUserConnectionPaginatedRepository

interface BriefUserConnectionRepository {

    suspend fun get(id: ID): BriefContact

    fun paginate(type: UserConnectionType): BriefUserConnectionPaginatedRepository
}