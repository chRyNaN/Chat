package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.chat.R
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.ui.activity.OpenSourceLicensesActivity
import com.chrynan.chat.ui.activity.WebActivity
import com.chrynan.chat.ui.adapter.SettingsCellItemAdapter
import com.chrynan.chat.ui.adapter.SettingsHeaderCellItemAdapter
import com.chrynan.chat.ui.adapter.adapterWith
import com.chrynan.chat.ui.adapter.settings
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

        adapter.items = settings {
            group(title = "Account") {
                cell(title = "Account Info")
                cell(title = "Contacts")
            }
            group(title = "App") {
                cell(title = "App Info"){
                    (activity as? BaseActivity)?.goToFragment(AppInfoFragment.newInstance())
                }
            }
            group(title = "Legal") {
                cell(title = "License") {
                    startActivity(
                        WebActivity.newIntent(
                            context = context!!,
                            url = "https://github.com/chRyNaN/Chat/blob/master/LICENSE",
                            title = "License"
                        )
                    )
                }
                cell(title = "Open Source Licenses") {
                    startActivity(OpenSourceLicensesActivity.newIntent(context!!))
                }
                cell(title = "App Code") {
                    startActivity(
                        WebActivity.newIntent(
                            context = context!!,
                            url = "https://github.com/chRyNaN/Chat",
                            title = "App Code"
                        )
                    )
                }
            }
        }
    }
}