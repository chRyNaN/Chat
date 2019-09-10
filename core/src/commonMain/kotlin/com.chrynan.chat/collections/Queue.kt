package com.chrynan.chat.collections

interface Queue<out T : Any> : Collection<T> {

    fun peek(): T

    fun peekOrNull(): T?
}