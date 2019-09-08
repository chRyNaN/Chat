package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.aaaah.ViewType
import com.chrynan.chat.R
import com.chrynan.chat.viewmodel.SettingsCellItemViewModel

class SettingsCellItemAdapter : BaseAdapter<SettingsCellItemViewModel>() {

    override val viewType = AdapterViewTypes.SETTINGS_CELL_LIST_ITEM

    override fun onHandlesItem(item: Any) = item is SettingsCellItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_settings_cell, parent, false)

    override fun onBindItem(view: View, item: SettingsCellItemViewModel) {
        val titleTextView = view.findViewById<TextView>(R.id.settingsCellTitleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.settingsCellDescriptionTextView)

        titleTextView.text = item.title
        descriptionTextView.text = item.description
    }
}