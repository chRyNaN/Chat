package com.chrynan.chat.mapper

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.ProjectDependency
import com.chrynan.chat.viewmodel.ProjectDependencyItemViewModel

class ProjectDependencyMapper @Inject constructor() : Mapper<ProjectDependency, List<ProjectDependencyItemViewModel>> {

    override suspend fun map(model: ProjectDependency): List<ProjectDependencyItemViewModel> =
        if (model.licenses.isEmpty()) {
            listOf(
                ProjectDependencyItemViewModel(
                    name = model.project,
                    version = model.version,
                    description = model.description,
                    url = model.url,
                    license = null
                )
            )
        } else {
            model.licenses.map {
                ProjectDependencyItemViewModel(
                    name = model.project,
                    version = model.version,
                    description = model.description,
                    url = model.url,
                    license = it
                )
            }
        }
}