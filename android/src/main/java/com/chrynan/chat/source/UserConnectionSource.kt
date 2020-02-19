package com.chrynan.chat.source

import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.reaction.model.account.UserConnectionType
import com.chrynan.chat.feature.reaction.model.contact.FullContact
import com.chrynan.chat.feature.reaction.model.contact.FullContactEdge
import com.chrynan.chat.feature.reaction.model.core.ID
import com.chrynan.chat.repository.PaginatedRepository
import com.chrynan.chat.repository.UserConnectionRepository

class UserConnectionSource @Inject constructor() : UserConnectionRepository {

    override suspend fun get(id: ID): FullContact {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun paginate(type: UserConnectionType): PaginatedRepository<FullContact, FullContactEdge> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}