package com.chrynan.chat.repository

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.Edge
import com.chrynan.chat.model.core.Node
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

@ExperimentalCoroutinesApi
class BasePaginatedSource<N : Node, E : Edge<N>>(private val getter: (first: Int, after: Cursor?) -> Connection<N, E>) :
    PaginatedRepository<N, E> {

    override val canLoadMore: Boolean
        get() = currentConnection?.pageInfo?.hasNextPage ?: false

    override var currentConnection: Connection<N, E>? = null
        private set

    private val nodes = mutableListOf<N>()

    private var producerScope: ProducerScope<List<N>>? = null

    override fun subscribe(first: Int, after: Cursor?): Flow<List<N>> =
        channelFlow {
            nodes.clear()
            producerScope?.cancel()
            producerScope = this

            val connection = getter(first, after)
            currentConnection = connection

            nodes.addAll(connection.nodes)

            send(nodes.toList())

            awaitClose()
        }

    override suspend fun load(next: Int) {
        if (canLoadMore) {
            val connection = getter(next, currentConnection?.pageInfo?.endCursor)
            currentConnection = connection

            nodes.addAll(connection.nodes)

            producerScope?.send(nodes)
        }
    }
}