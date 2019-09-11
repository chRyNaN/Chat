package com.chrynan.chat.collections

data class MultipleStackResult<K : Any, V : Any>(
    val key: K,
    val value: Stack<V>
) {

    val stack: Stack<V> = value

    fun toPair(): Pair<K, Stack<V>> = key to value
}