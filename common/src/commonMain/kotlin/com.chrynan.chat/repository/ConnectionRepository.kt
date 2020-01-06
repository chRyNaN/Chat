package com.chrynan.chat.repository

import com.chrynan.chat.model.core.Connection
import com.chrynan.chat.model.core.Edge
import com.chrynan.chat.model.core.Node

interface ConnectionRepository<N : Node, E : Edge<N>, C : Connection<N, E>> : PaginatedRepository<C>