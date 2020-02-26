package com.chrynan.chat.source

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.account.UserConnectionType
import com.chrynan.chat.model.contact.BriefContact
import com.chrynan.chat.model.contact.BriefContactConnection
import com.chrynan.chat.model.contact.BriefContactEdge
import com.chrynan.chat.model.contact.PersonName
import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.PageInfo
import com.chrynan.chat.repository.BriefUserConnectionRepository
import com.chrynan.chat.repository.paginate.BasePaginatedSource
import com.chrynan.chat.repository.paginate.BriefUserConnectionPaginatedRepository
import com.chrynan.logger.Loggable

class BriefUserConnectionSource @Inject constructor(logger: Loggable) :
    BasePaginatedSource<BriefContact, BriefContactEdge>(),
    BriefUserConnectionPaginatedRepository,
    BriefUserConnectionRepository {

    override suspend fun get(id: ID): BriefContact {
        // TODO load real data
        return BriefContact(
            id = "",
            imageUri = null,
            isPinned = false,
            name = PersonName(
                firstName = "Chris",
                fullName = ""
            )
        )
    }

    override fun paginate(type: UserConnectionType) = this

    override val loadMoreFunction: suspend (first: Int, after: Cursor?) -> Connection<BriefContact, BriefContactEdge>
        get() = { _, _ ->
            // TODO load real data

            val contactOne = BriefContact(
                id = "one",
                imageUri = null,
                isPinned = false,
                name = PersonName(
                    firstName = "One",
                    fullName = "One"
                )
            )

            val contactTwo = BriefContact(
                id = "two",
                imageUri = null,
                isPinned = false,
                name = PersonName(
                    firstName = "Two",
                    fullName = "Two"
                )
            )

            val contactThree = BriefContact(
                id = "three",
                imageUri = null,
                isPinned = false,
                name = PersonName(
                    firstName = "Three",
                    fullName = "Three"
                )
            )

            BriefContactConnection(
                pageInfo = PageInfo(
                    startCursor = null,
                    endCursor = null,
                    hasNextPage = false,
                    hasPreviousPage = false
                ),
                totalCount = 0,
                nodes = listOf(contactOne, contactTwo, contactThree)
            )
        }
}