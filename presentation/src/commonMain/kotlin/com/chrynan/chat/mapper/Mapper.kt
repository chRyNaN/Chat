package com.chrynan.chat.mapper

interface Mapper<T, R> {

    suspend fun map(model: T): R
}