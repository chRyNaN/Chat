package com.chrynan.chat.repository

import com.chrynan.chat.model.ProjectDependency

interface ProjectDependencyRepository {

    suspend fun getAll(): List<ProjectDependency>
}