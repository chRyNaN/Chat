package com.chrynan.chat.repository

import com.chrynan.chat.feature.reaction.model.core.Connection
import com.chrynan.chat.feature.reaction.model.core.Cursor
import com.chrynan.chat.feature.reaction.model.core.Edge
import com.chrynan.chat.feature.reaction.model.core.Node
import kotlinx.coroutines.flow.Flow

interface PaginatedRepository<N : Node, E : Edge<N>> {

    val canLoadMore: Boolean

    val currentConnection: Connection<N, E>?

    fun subscribe(first: Int = 10, after: Cursor? = null): Flow<List<N>>

    suspend fun load(next: Int)
}