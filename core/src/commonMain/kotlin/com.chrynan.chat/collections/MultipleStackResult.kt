package com.chrynan.chat.collections

data class MultipleStackResult<K : Any, V : Any>(
    val key: K,
    val value: MutableStack<V>
) {

    val stack: MutableStack<V> = value

    fun toPair(): Pair<K, Stack<V>> = key to value
}