package com.chrynan.chat.collections

interface Deque<out T : Any> : Collection<T> {

    fun getFirst(): T

    fun getFirstOrNull(): T? =
        try {
            getFirst()
        } catch (e: NoSuchElementException) {
            null
        }

    fun peekFirst(): T = getFirst()

    fun peekFirstOrNull(): T? = getFirstOrNull()

    fun getLast(): T

    fun getLastOrNull(): T? =
        try {
            getLast()
        } catch (e: NoSuchElementException) {
            null
        }

    fun peekLast(): T = getLast()

    fun peekLastOrNull(): T? = getLastOrNull()

    fun descendingIterator(): Iterator<T>
}