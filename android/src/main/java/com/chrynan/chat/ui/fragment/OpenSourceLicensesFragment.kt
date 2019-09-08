package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.chat.R
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.ui.adapter.SettingsCellItemAdapter
import com.chrynan.chat.ui.adapter.SettingsHeaderCellItemAdapter
import com.chrynan.chat.ui.adapter.adapterWith
import com.chrynan.chat.ui.adapter.settings
import com.google.android.material.appbar.CollapsingToolbarLayout

class OpenSourceLicensesFragment : BaseFragment() {

    companion object {

        fun newInstance() = OpenSourceLicensesFragment()
    }

    private val recyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recyclerView) }
    private val collapsingToolbarLayout by lazy { view!!.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout) }
    private val toolbar by lazy { view!!.findViewById<Toolbar>(R.id.toolbar) }

    private val title by lazy { getString(R.string.open_source_licenses_title) }

    private val groupCommonTitle by lazy { getString(R.string.open_source_licenses_group_common) }
    private val groupAndroidTitle by lazy { getString(R.string.open_source_licenses_group_android) }
    private val itemKotlinTitle by lazy { getString(R.string.open_source_licenses_item_kotlin) }
    private val itemAndroidSupport by lazy { getString(R.string.open_source_licenses_item_android_support) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_open_source_licenses, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout.title = title
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_back)
        toolbar.setNavigationOnClickListener { (activity as? BaseActivity)?.goBack() }

        val adapter = adapterWith {
            +SettingsHeaderCellItemAdapter()
            +SettingsCellItemAdapter()
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        adapter.items = settings {
            group(title = groupCommonTitle) {
                cell(title = itemKotlinTitle)
            }
            group(title = groupAndroidTitle) {
                cell(title = itemAndroidSupport)
            }
        }
    }
}