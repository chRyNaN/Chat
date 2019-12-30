package com.chrynan.chat.model

interface Connection<N : Node, E : Edge<N>> {

    val totalCount: Int

    val pageInfo: PageInfo

    val edges: List<E>

    val nodes: List<N>
}