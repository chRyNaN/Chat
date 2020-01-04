package com.chrynan.chat.view

import com.chrynan.chat.model.ColorInt

interface AppInfoView : View {

    fun showVersion(label: String, version: String)

    fun hideVersion()

    fun showVersionCode(label: String, versionCode: String)

    fun hideVersionCode()

    fun showUpdateAvailable(label: String, updateDescription: String, descriptionColorInt: ColorInt)

    fun hideUpdateAvailable()

    fun showAppStoreID(label: String, id: String)

    fun hideAppStoreID()

    fun showLicense(label: String, licenseName: String)

    fun hideLicense()

    fun showSourceCode(label: String, title: String)

    fun hideSourceCode()
}