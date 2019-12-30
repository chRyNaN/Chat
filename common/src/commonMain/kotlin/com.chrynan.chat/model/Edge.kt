package com.chrynan.chat.model

interface Edge<N : Node> {

    val cursor: Cursor

    val node: N
}