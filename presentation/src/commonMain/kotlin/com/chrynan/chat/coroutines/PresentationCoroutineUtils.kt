package com.chrynan.chat.coroutines

import com.chrynan.chat.mapper.Mapper
import kotlinx.coroutines.flow.Flow

fun <T, R> Flow<Collection<T>>.mapEachWith(mapper: Mapper<T, R>): Flow<List<R>> = mapEach { mapper.map(it) }