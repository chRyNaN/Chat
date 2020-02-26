package com.chrynan.chat.repository.paginate

import com.chrynan.chat.model.contact.BriefContact
import com.chrynan.chat.model.contact.BriefContactEdge

interface BriefUserConnectionPaginatedRepository :
    PaginatedRepository<BriefContact, BriefContactEdge>