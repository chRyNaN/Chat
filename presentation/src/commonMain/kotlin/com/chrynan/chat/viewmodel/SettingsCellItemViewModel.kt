package com.chrynan.chat.viewmodel

data class SettingsCellItemViewModel(
    val title: String,
    val description: String? = null,
    val onClick: (() -> Unit)? = null
) : ViewModel