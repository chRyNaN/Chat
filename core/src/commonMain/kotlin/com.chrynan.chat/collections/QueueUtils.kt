package com.chrynan.chat.collections

typealias Stack<T> = Queue<T>

inline fun <reified T : Any> stackOf(vararg elements: T): Stack<T> =
    LIFOQueue<T>().apply { addAll(listOf(*elements)) }

inline fun <reified T : Any> mutableStackOf(vararg elements: T): Stack<T> =
    LIFOQueue<T>().apply { addAll(listOf(*elements)) }

inline fun <reified T : Any> Collection<T>.toStack(): Stack<T> {
    val queue = LIFOQueue<T>()

    queue.addAll(toList())

    return queue
}

fun <T : Any> emptyStack(): Queue<T> = EmptyStack