package com.chrynan.chat.json

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.ProjectDependency
import com.chrynan.chat.model.ProjectLicense

class ProjectDependencyConverter @Inject constructor() : Converter {

    override fun canConvert(cls: Class<*>) = cls == ProjectDependency::class.java

    override fun fromJson(jv: JsonValue): ProjectDependency? {
        val obj = jv.obj ?: return null

        val project = obj.string(ProjectDependency.NAME_PROJECT) ?: return null
        val version = obj.string(ProjectDependency.NAME_VERSION) ?: return null
        val dependency = obj.string(ProjectDependency.NAME_DEPENDENCY) ?: return null
        val description = obj.string(ProjectDependency.NAME_DESCRIPTION)
        val url = obj.string(ProjectDependency.NAME_URL)
        val year = obj.string(ProjectDependency.NAME_YEAR)
        val developers = obj.array<String>(ProjectDependency.NAME_DEVELOPERS)?.map { it } ?: emptyList()
        val licenses = obj.array<JsonObject>(ProjectDependency.NAME_LICENSES)?.mapChildren {
            ProjectLicense(
                license = it.string(ProjectLicense.NAME_LICENSE)
                    ?: "",
                licenseUrl = it.string(ProjectLicense.NAME_LICENSE_URL)
            )
        }?.filterNotNull() ?: emptyList()

        return ProjectDependency(
            project = project,
            version = version,
            dependency = dependency,
            description = description,
            url = url,
            year = year,
            developers = developers,
            licenses = licenses
        )
    }

    override fun toJson(value: Any): String {
        TODO()
    }
}