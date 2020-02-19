package com.chrynan.chat.feature.settings.mapper

import com.chrynan.chat.mapper.Mapper
import com.chrynan.chat.feature.reaction.model.ProjectDependency
import com.chrynan.chat.feature.settings.viewmodel.ProjectDependencyItemViewModel
import javax.inject.Inject

class ProjectDependencyMapper @Inject constructor() :
    Mapper<ProjectDependency, List<ProjectDependencyItemViewModel>> {

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