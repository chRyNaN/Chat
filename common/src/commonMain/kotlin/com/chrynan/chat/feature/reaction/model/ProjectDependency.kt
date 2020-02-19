package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.json.Json

data class ProjectDependency(
    @Json(NAME_PROJECT) val project: String,
    @Json(NAME_VERSION) val version: String,
    @Json(NAME_DEPENDENCY) val dependency: String,
    @Json(NAME_DESCRIPTION) val description: String? = null,
    @Json(NAME_URL) val url: String? = null,
    @Json(NAME_YEAR) val year: String? = null,
    @Json(NAME_DEVELOPERS) val developers: List<String> = emptyList(),
    @Json(NAME_LICENSES) val licenses: List<ProjectLicense> = emptyList()
) {

    companion object {

        const val NAME_PROJECT = "project"
        const val NAME_VERSION = "version"
        const val NAME_DEPENDENCY = "dependency"
        const val NAME_DESCRIPTION = "description"
        const val NAME_URL = "url"
        const val NAME_YEAR = "year"
        const val NAME_DEVELOPERS = "developers"
        const val NAME_LICENSES = "licenses"
    }
}