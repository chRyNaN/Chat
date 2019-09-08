package com.chrynan.chat.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.aaaah.ViewType
import com.chrynan.chat.R
import com.chrynan.chat.viewmodel.SettingsHeaderCellItemViewModel

class SettingsHeaderCellItemAdapter : BaseAdapter<SettingsHeaderCellItemViewModel>() {

    override val viewType = AdapterViewTypes.SETTINGS_HEADER_CELL_LIST_ITEM

    override fun onHandlesItem(item: Any) = item is SettingsHeaderCellItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_settings_header_cell,
            parent,
            false
        )

    override fun onBindItem(view: View, item: SettingsHeaderCellItemViewModel) {
        val textView = view.findViewById<TextView>(R.id.settingsHeaderCellTitleTextView)

        textView.text = item.title
    }
}