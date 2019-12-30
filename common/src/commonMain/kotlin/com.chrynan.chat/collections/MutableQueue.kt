package com.chrynan.chat.collections

interface MutableQueue<T : Any> : Queue<T> {

    fun add(element: T)

    fun addAll(elements: Collection<T>): Boolean

    fun push(element: T) = add(element)

    fun pushAll(elements: Collection<T>): Boolean = addAll(elements)

    fun remove(): T

    fun removeOrNull(): T? =
        try {
            remove()
        } catch (e: NoSuchElementException) {
            null
        }

    fun poll(): T? = removeOrNull()

    fun pop(): T? = poll()
}