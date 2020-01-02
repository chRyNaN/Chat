package com.chrynan.chat.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.model.ProjectLicense

data class ProjectDependencyItemViewModel(
    val name: String,
    val version: String,
    val description: String? = null,
    val url: String? = null,
    val license: ProjectLicense? = null
) : AdapterItem {

    override val uniqueAdapterId = "$name$version$license".asUniqueAdapterId()
}