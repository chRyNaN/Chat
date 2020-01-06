package com.chrynan.chat.repository

import com.chrynan.chat.model.core.Cursor
import kotlinx.coroutines.flow.Flow

interface PaginatedRepository<T> {

    fun subscribe(first: Int = 10, after: Cursor? = null): Flow<List<T>>

    suspend fun load(next: Int)
}