package com.chrynan.chat.collections

object EmptyStack : LIFOQueue<Nothing>(),
    Queue<Nothing>,
    MutableQueue<Nothing> {

    override fun peek() = throw NoSuchElementException("Empty Queue has no items.")

    override fun peekOrNull() = throw NoSuchElementException("Empty Queue has no items.")

    override val size = 0

    override fun contains(element: Nothing) = false

    override fun containsAll(elements: Collection<Nothing>) = elements.isEmpty()

    override fun isEmpty() = true

    override fun iterator() = EmptyIterator

    override fun add(element: Nothing) =
        throw IllegalStateException("Cannot add elements to an Empty Queue.")

    override fun addAll(elements: Collection<Nothing>) =
        throw IllegalStateException("Cannot add elements to an Empty Queue.")

    override fun remove() =
        throw IllegalStateException("Cannot remove elements from an Empty Queue.")
}