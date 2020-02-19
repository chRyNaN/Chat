package com.chrynan.chat.repository

import com.chrynan.chat.feature.reaction.model.ProjectDependency

interface ProjectDependencyRepository {

    suspend fun getAll(): List<ProjectDependency>
}