package com.chrynan.chat.ui.adapter

import com.chrynan.chat.viewmodel.SettingsCellItemViewModel
import com.chrynan.chat.viewmodel.SettingsHeaderCellItemViewModel
import com.chrynan.chat.viewmodel.ViewModel

@SettingsDslMarker
class SettingsListItemBuilder {

    private val items = mutableListOf<ViewModel>()

    fun group(title: String, builder: SettingsGroupBuilder.() -> Unit) {
        val groupBuilder = SettingsGroupBuilder()
        builder.invoke(groupBuilder)
        items.add(SettingsHeaderCellItemViewModel(title = title))
        items.addAll(groupBuilder.build())
    }

    internal fun build(): List<ViewModel> = items
}

@SettingsDslMarker
class SettingsGroupBuilder {

    private val items = mutableListOf<SettingsCellItemViewModel>()

    fun cell(title: String, description: String? = null, onClick: (() -> Unit)? = null) {
        items.add(
            SettingsCellItemViewModel(
                title = title,
                description = description,
                onClick = onClick
            )
        )
    }

    internal fun build(): List<SettingsCellItemViewModel> = items
}

@DslMarker
annotation class SettingsDslMarker

fun settings(builder: SettingsListItemBuilder.() -> Unit): List<ViewModel> {
    val settingsBuilder = SettingsListItemBuilder()
    builder.invoke(settingsBuilder)
    return settingsBuilder.build()
}