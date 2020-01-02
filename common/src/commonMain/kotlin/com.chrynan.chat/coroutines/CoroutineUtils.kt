package com.chrynan.chat.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> flowOf(creator: suspend () -> T): Flow<T> = flow { emit(creator()) }