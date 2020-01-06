package com.chrynan.chat.source

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.contact.Contact
import com.chrynan.chat.model.contact.ContactConnection
import com.chrynan.chat.model.core.Cursor
import com.chrynan.chat.repository.ContactListRepository
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class ContactListSource @Inject constructor() : ContactListRepository {

    private var lastConnection: ContactConnection? = null
    private var producerScope: ProducerScope<List<Contact>>? = null
    private var subscribeFirst: Int = 0
    private var subscribeAfter: Cursor? = null

    override fun subscribe(first: Int, after: Cursor?): Flow<List<Contact>> = channelFlow {
        subscribeFirst = first
        subscribeAfter = after

        producerScope = this

        val connection = get(first, after)
        lastConnection = connection

        send(connection.nodes)
    }

    override suspend fun load(next: Int) {
        val connection = get(next, lastConnection?.pageInfo?.endCursor)
        lastConnection = connection

        producerScope?.send(connection.nodes)
    }

    private suspend fun get(first: Int, after: Cursor?): ContactConnection {
        TODO()
    }
}