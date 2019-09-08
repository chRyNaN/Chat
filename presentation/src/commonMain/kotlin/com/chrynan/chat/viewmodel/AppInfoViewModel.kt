package com.chrynan.chat.viewmodel

data class AppInfoViewModel(
    val version: String,
    val updateDescription: String,
    val isUpToDate: Boolean
) : ViewModel