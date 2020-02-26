package com.chrynan.chat.model

import com.chrynan.chat.model.core.UriString

class ProjectInfo(
    val name: String, // Chat
    val version: String, // 1.0.0
    val versionCode: String, // 1
    val group: String, // com.chrynan
    val id: String, // com.chrynan.chat
    val sourceUri: UriString, // link to source code
    val licenseUri: UriString, // link to license
    val licenseName: String // Apache 2.0
)