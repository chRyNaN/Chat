package com.chrynan.chat.feature.reaction.model

import com.chrynan.chat.json.Json

data class ProjectLicense(
    @Json(NAME_LICENSE) val license: String,
    @Json(NAME_LICENSE_URL) val licenseUrl: String? = null
) {

    companion object {

        const val NAME_LICENSE = "license"
        const val NAME_LICENSE_URL = "license_url"
    }
}