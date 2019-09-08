package com.chrynan.chat.view

interface AppInfoView : View {

    fun showVersion(version: String)

    fun hideVersion()

    fun showUpdateDescription(updateDescription: String)

    fun hideUpdateDescription()
}