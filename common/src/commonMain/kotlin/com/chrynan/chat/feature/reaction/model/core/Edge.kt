package com.chrynan.chat.feature.reaction.model.core

interface Edge<N : Node> {

    val cursor: Cursor

    val node: N
}