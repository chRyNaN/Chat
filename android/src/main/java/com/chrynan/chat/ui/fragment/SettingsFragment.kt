package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.chat.R
import com.chrynan.chat.ui.adapter.SettingsCellItemAdapter
import com.chrynan.chat.ui.adapter.SettingsHeaderCellItemAdapter
import com.chrynan.chat.ui.adapter.adapterWith
import com.chrynan.chat.viewmodel.SettingsCellItemViewModel
import com.chrynan.chat.viewmodel.SettingsHeaderCellItemViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout

class SettingsFragment : BaseFragment() {

    companion object {

        fun newInstance() = SettingsFragment()
    }

    private val collapsingToolbarLayout by lazy { view!!.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout) }
    private val recyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recyclerView) }

    private val titleText by lazy { getString(R.string.app_bar_title_settings) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout.title = titleText

        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = adapterWith {
            +SettingsHeaderCellItemAdapter()
            +SettingsCellItemAdapter()
        }

        recyclerView.adapter = adapter

        adapter.items = listOf(
            SettingsHeaderCellItemViewModel(title = "Settings Header"),
            SettingsCellItemViewModel(title = "Title", description = "Description")
        )
    }
}