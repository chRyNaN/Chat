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
import com.chrynan.chat.feature.settings.viewmodel.SettingsCellItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import javax.inject.Inject

@Adapter
class SettingsCellItemAdapter @Inject constructor() : BaseAdapter<SettingsCellItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is SettingsCellItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_settings_cell, parent, false)

    override fun onBindItem(view: View, item: SettingsCellItemViewModel) {
        val titleTextView = view.findViewById<TextView>(R.id.settingsCellTitleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.settingsCellDescriptionTextView)

        titleTextView.text = item.title
        descriptionTextView.text = item.description
        descriptionTextView.visibility = if (item.description == null) View.GONE else View.VISIBLE

        item.onClick?.let { onClick ->
            view.setOnClickListener { onClick() }
        }
    }
}