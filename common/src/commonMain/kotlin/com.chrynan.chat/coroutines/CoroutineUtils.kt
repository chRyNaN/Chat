package com.chrynan.chat.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

fun <T> flowOf(creator: suspend () -> T): Flow<T> = flow { emit(creator()) }

fun <T, R> Flow<Collection<T>>.mapEach(block: suspend (T) -> R): Flow<List<R>> =
    map { collection -> collection.map { item -> block(item) } }