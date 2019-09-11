package com.chrynan.chat.collections

class MultipleStack<K : Any, V : Any> : Collection<MultipleStackResult<K, V>>,
    Queue<MultipleStackResult<K, V>>,
    MutableQueue<MultipleStackResult<K, V>> {

    private val mapOfStacks = LinkedHashMap<K, Stack<V>>()

    override val size: Int
        get() = mapOfStacks.size

    override fun contains(element: MultipleStackResult<K, V>) =
        mapOfStacks[element.key] == element.value

    override fun containsAll(elements: Collection<MultipleStackResult<K, V>>): Boolean {
        for (element in elements) {
            if (!contains(element)) return false
        }

        return true
    }

    override fun isEmpty() = mapOfStacks.isEmpty()

    override fun iterator() =
        mapOfStacks.entries
            .map { MultipleStackResult(key = it.key, value = it.value) }
            .reversed()
            .iterator()

    override fun peek(): MultipleStackResult<K, V> {
        val last = mapOfStacks.entries.last()

        return MultipleStackResult(key = last.key, value = last.value)
    }

    override fun peekOrNull(): MultipleStackResult<K, V>? =
        try {
            peek()
        } catch (e: Exception) {
            null
        }

    override fun add(element: MultipleStackResult<K, V>) {
        mapOfStacks[element.key] = element.value
    }

    override fun addAll(elements: Collection<MultipleStackResult<K, V>>): Boolean {
        mapOfStacks.putAll(elements.map { it.key to it.value })
        return true
    }

    override fun remove(): MultipleStackResult<K, V> {
        val last = mapOfStacks.entries.last()

        mapOfStacks.remove(last.key)

        return MultipleStackResult(key = last.key, value = last.value)
    }

    fun containsKey(key: K) = mapOfStacks.containsKey(key)

    fun get(key: K): Stack<V> = mapOfStacks[key]!!

    fun getOrNull(key: K): Stack<V>? = mapOfStacks[key]

    fun remove(key: K): MultipleStackResult<K, V> {
        val item = mapOfStacks.remove(key)

        return MultipleStackResult(key = key, value = item!!)
    }

    fun removeOrNull(key: K): MultipleStackResult<K, V>? =
        try {
            remove(key)
        } catch (e: Exception) {
            null
        }
}