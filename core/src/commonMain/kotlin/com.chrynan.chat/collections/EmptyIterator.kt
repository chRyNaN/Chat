package com.chrynan.chat.collections

object EmptyIterator : MutableListIterator<Nothing> {

    override fun hasNext() = false

    override fun hasPrevious() = false

    override fun nextIndex() = 0

    override fun previousIndex() = -1

    override fun next() = throw NoSuchElementException()

    override fun previous() = throw NoSuchElementException()

    override fun add(element: Nothing) = throw IllegalStateException()

    override fun remove() = throw IllegalStateException()

    override fun set(element: Nothing) = throw IllegalStateException()
}