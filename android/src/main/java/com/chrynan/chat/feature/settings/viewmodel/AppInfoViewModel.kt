package com.chrynan.chat.feature.settings.viewmodel

import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.viewmodel.ViewModel

data class AppInfoViewModel(
    val versionLabel: String,
    val version: String,
    val versionCodeLabel: String,
    val versionCode: String,
    val updateAvailableLabel: String,
    val updateAvailableDescription: String? = null,
    val updateAvailableDescriptionColorInt: ColorInt,
    val appStoreIDLabel: String,
    val appStoreID: String,
    val licenseLabel: String,
    val licenseName: String,
    val licenseUri: UriString,
    val sourceCodeLabel: String,
    val sourceCodeTitle: String,
    val sourceCodeUri: UriString
) : ViewModel