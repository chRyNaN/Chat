package com.chrynan.chat.repository.paginate

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.model.core.Edge
import com.chrynan.chat.model.core.Node
import com.chrynan.logger.Logger
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

@ExperimentalCoroutinesApi
abstract class BasePaginatedSource<N : Node, E : Edge<N>> : PaginatedRepository<N, E> {

    abstract val loadMoreFunction: suspend (first: Int, after: Cursor?) -> Connection<N, E>

    override val canLoadMore: Boolean
        get() = currentConnection?.pageInfo?.hasNextPage ?: false

    override var currentConnection: Connection<N, E>? = null
        protected set

    private val nodes = mutableListOf<N>()

    private var producerScope: ProducerScope<List<N>>? = null

    override fun subscribe(first: Int, after: Cursor?): Flow<List<N>> =
        channelFlow {
            Logger.logWarning(message = "subscribe")

            nodes.clear()
            producerScope?.cancel()
            producerScope = this

            val connection = loadMoreFunction(first, after)
            currentConnection = connection

            nodes.addAll(connection.nodes)

            Logger.logWarning(message = "connection = $connection")

            send(nodes.toList())

            awaitClose()
        }

    override suspend fun load(next: Int) {
        if (canLoadMore) {
            val connection = loadMoreFunction(next, currentConnection?.pageInfo?.endCursor)
            currentConnection = connection

            nodes.addAll(connection.nodes)

            producerScope?.send(nodes)
        }
    }
}