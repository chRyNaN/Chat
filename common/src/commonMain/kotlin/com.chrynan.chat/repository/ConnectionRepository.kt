package com.chrynan.chat.repository

import com.chrynan.chat.model.Connection
import com.chrynan.chat.model.Edge
import com.chrynan.chat.model.Node

interface ConnectionRepository<N : Node, E : Edge<N>, C : Connection<N, E>> : PaginatedRepository<C>