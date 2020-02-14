package com.chrynan.chat.feature.settings.viewmodel

import com.chrynan.chat.viewmodel.ViewModel

data class SettingsCellItemViewModel(
    val title: String,
    val description: String? = null,
    val onClick: (() -> Unit)? = null
) : ViewModel