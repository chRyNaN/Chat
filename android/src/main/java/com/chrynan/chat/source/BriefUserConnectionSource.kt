package com.chrynan.chat.source

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.account.UserConnectionType
import com.chrynan.chat.model.contact.BriefContact
import com.chrynan.chat.model.contact.BriefContactConnection
import com.chrynan.chat.model.contact.BriefContactEdge
import com.chrynan.chat.model.contact.PersonName
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.PageInfo
import com.chrynan.chat.repository.BasePaginatedSource
import com.chrynan.chat.repository.BriefUserConnectionRepository
import com.chrynan.chat.repository.PaginatedRepository
import com.chrynan.logger.Loggable

class BriefUserConnectionSource @Inject constructor(logger: Loggable) :
    BriefUserConnectionRepository,
    Loggable by logger {

    override suspend fun get(id: ID): BriefContact {
        // TODO load real data
        logWarning(message = "Testing")

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

    override fun paginate(type: UserConnectionType): PaginatedRepository<BriefContact, BriefContactEdge> =
        BasePaginatedSource { first, cursor ->
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