@file:Suppress("NOTHING_TO_INLINE")

package com.chrynan.chat.collections

typealias Stack<T> = Queue<T>
typealias MutableStack<T> = MutableQueue<T>

inline fun <T : Any> stackOf(vararg elements: T): Stack<T> =
    LIFOQueue<T>().apply { addAll(listOf(*elements)) }

inline fun <T : Any> mutableStackOf(vararg elements: T): MutableStack<T> =
    LIFOQueue<T>().apply { addAll(listOf(*elements)) }

inline fun <T : Any> Collection<T>.toStack(): Stack<T> {
    val queue = LIFOQueue<T>()

    queue.addAll(toList())

    return queue
}

fun <T : Any> emptyStack(): Queue<T> = EmptyStack

inline fun <T : Any> Stack<T>.toMutableStack(): MutableStack<T> =
    if (this is LIFOQueue<T>) this else LIFOQueue<T>().apply { addAll(this) }

inline fun <T : Any> mutableDequeOf(vararg elements: T): MutableDeque<T> =
    MutableListDeque<T>().apply { addAllFirst(elements.toList()) }

inline fun <T : Any> MutableQueue<T>.clear() {
    val s = size
    for (i in s..0) {
        pop()
    }
}

inline fun <T : Any> MutableDeque<T>.clear() {
    val s = size
    for (i in s..0) {
        removeLastOrNull()
    }
}

inline fun <T : Any> MutableQueue<T>.removeAllExceptForLast() {
    if (size > 1) {
        val s = size
        for (i in 2..s) {
            pop()
        }
    }
}