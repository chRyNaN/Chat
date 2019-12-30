package com.chrynan.chat.collections

open class MutableListDeque<T : Any> : Collection<T>,
    Deque<T>,
    MutableDeque<T> {

    private val mutableList: MutableList<T> = mutableListOf()

    override val size
        get() = mutableList.size

    override fun getFirst(): T {
        if (mutableList.isEmpty()) throw NoSuchElementException("Cannot call getFirst() on Deque because there are no elements.")

        return mutableList[0]
    }

    override fun getLast(): T {
        if (mutableList.isEmpty()) throw NoSuchElementException("Cannot call getLast() on Deque because there are no elements.")

        return mutableList[mutableList.size - 1]
    }

    override fun iterator() = mutableList.iterator()

    override fun descendingIterator() = mutableList.asReversed().iterator()

    override fun contains(element: T) = mutableList.contains(element)

    override fun containsAll(elements: Collection<T>) = mutableList.containsAll(elements)

    override fun isEmpty() = mutableList.isEmpty()

    override fun addFirst(element: T) = mutableList.add(0, element)

    override fun addLast(element: T) = mutableList.add(mutableList.size, element)

    override fun addAllFirst(elements: Collection<T>) = mutableList.addAll(0, elements)

    override fun addAllLast(elements: Collection<T>) =
        mutableList.addAll(mutableList.size, elements)

    override fun removeFirst(): T {
        if (mutableList.isEmpty()) throw NoSuchElementException("Cannot call removeFirst() on Deque because there are no elements.")

        return mutableList.removeAt(0)
    }

    override fun removeLast(): T {
        if (mutableList.isEmpty()) throw NoSuchElementException("Cannot call removeLast() on Deque because there are no elements.")

        return mutableList.removeAt(mutableList.size - 1)
    }

    override fun removeFirstOccurrence(element: T): Boolean {
        if (mutableList.isEmpty()) return false

        for (i in 0 until mutableList.size) {
            if (mutableList[i] == element) {
                mutableList.removeAt(i)
                return true
            }
        }

        return false
    }

    override fun removeLastOccurrence(element: T): Boolean {
        if (mutableList.isEmpty()) return false

        for (i in mutableList.size - 1 downTo 0) {
            if (mutableList[i] == element) {
                mutableList.removeAt(i)
                return true
            }
        }

        return false
    }

    override fun removeAllOccurrences(element: T) = mutableList.removeAll { it == element }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MutableListDeque<*>

        if (mutableList != other.mutableList) return false

        return true
    }

    override fun hashCode() = mutableList.hashCode()

    override fun toString() = "MutableListDeque(mutableList=$mutableList)"

    fun toPrettyString() = mutableList.toString()
}