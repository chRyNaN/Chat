package com.chrynan.chat.collections

interface MutableDeque<T : Any> : Deque<T> {

    fun addFirst(element: T)

    fun addLast(element: T)

    fun addAllFirst(elements: Collection<T>): Boolean

    fun addAllLast(elements: Collection<T>): Boolean

    fun pushFirst(element: T) = addFirst(element)

    fun pushLast(element: T) = addLast(element)

    fun pushAllFirst(elements: Collection<T>): Boolean = addAllFirst(elements)

    fun pushAllLast(elements: Collection<T>): Boolean = addAllLast(elements)

    fun removeFirst(): T

    fun removeFirstOrNull(): T? =
        try {
            removeFirst()
        } catch (e: NoSuchElementException) {
            null
        }

    fun removeLast(): T

    fun removeLastOrNull(): T? =
        try {
            removeLast()
        } catch (e: NoSuchElementException) {
            null
        }

    fun pollFirst(): T? = removeFirstOrNull()

    fun pollLast(): T? = removeLastOrNull()

    fun removeFirstOccurrence(element: T): Boolean

    fun removeLastOccurrence(element: T): Boolean

    fun removeAllOccurrences(element: T): Boolean
}