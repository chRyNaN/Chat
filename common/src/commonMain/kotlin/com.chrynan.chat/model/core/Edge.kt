package com.chrynan.chat.model.core

interface Edge<N : Node> {

    val cursor: Cursor

    val node: N
}