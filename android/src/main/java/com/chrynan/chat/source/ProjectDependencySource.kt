package com.chrynan.chat.source

import com.beust.klaxon.Klaxon
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.json.ProjectDependencyConverter
import com.chrynan.chat.model.ProjectDependency
import com.chrynan.chat.repository.ProjectDependencyRepository
import com.chrynan.chat.utils.ApplicationContext
import kotlinx.coroutines.withContext

class ProjectDependencySource @Inject constructor(
    private val context: ApplicationContext,
    private val dispatchers: CoroutineDispatchers,
    private val converter: ProjectDependencyConverter
) : ProjectDependencyRepository {

    companion object {

        private const val OPEN_SOURCE_JSON_FILE = "open_source_licenses.json"
    }

    @Suppress("BlockingMethodInNonBlockingContext") // TODO FIX!!
    override suspend fun getAll(): List<ProjectDependency> {
        return withContext(dispatchers.io) {
            val json = context.assets.open(OPEN_SOURCE_JSON_FILE).bufferedReader().use {
                it.readText()
            }
            context.assets.open(OPEN_SOURCE_JSON_FILE).use {
                Klaxon()
                    .converter(converter)
                    .parseArray<ProjectDependency>(it)
            }
        } ?: emptyList()
    }
}