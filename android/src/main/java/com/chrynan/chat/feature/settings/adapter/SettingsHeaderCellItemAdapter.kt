package com.chrynan.chat.feature.settings.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.settings.viewmodel.SettingsHeaderCellItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import javax.inject.Inject

@Adapter
class SettingsHeaderCellItemAdapter @Inject constructor() :
    BaseAdapter<SettingsHeaderCellItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

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