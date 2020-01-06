package com.chrynan.chat.repository

import com.chrynan.chat.model.core.Cursor
import kotlinx.coroutines.flow.Flow

interface PaginatedRepository<T> {

    fun subscribe(first: Int, after: Cursor? = null): Flow<T>

    suspend fun load(next: Int)
}