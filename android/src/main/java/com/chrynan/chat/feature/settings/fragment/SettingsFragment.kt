package com.chrynan.chat.feature.settings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.chat.R
import com.chrynan.chat.feature.referral.activity.ReferralActivity
import com.chrynan.chat.feature.settings.activity.OpenSourceLicensesActivity
import com.chrynan.chat.feature.settings.adapter.SettingsCellItemAdapter
import com.chrynan.chat.feature.settings.adapter.SettingsHeaderCellItemAdapter
import com.chrynan.chat.feature.settings.adapter.settings
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.ui.adapter.core.adapterWith
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.viewmodel.ViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout

class SettingsFragment : BaseFragment() {

    companion object {

        fun newInstance() = SettingsFragment()
    }

    private val collapsingToolbarLayout
        get() = view!!.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
    private val recyclerView
        get() = view!!.findViewById<RecyclerView>(R.id.recyclerView)

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

        val adapter = adapterWith<ViewModel> {
            +SettingsHeaderCellItemAdapter()
            +SettingsCellItemAdapter()
        }

        recyclerView.adapter = adapter

        adapter.items = settings {
            group(title = "Account") {
                cell(title = "Account Info")
            }
            group(title = "App") {
                cell(title = "App Info") {
                    (activity as? BaseActivity)?.goToFragment(AppInfoFragment.newInstance())
                }
                cell(title = "Invite Friends") {
                    startActivity(ReferralActivity.newIntent(context!!))
                }
            }
            group(title = "Legal") {
                cell(title = "Open Source Licenses") {
                    startActivity(OpenSourceLicensesActivity.newIntent(context!!))
                }
            }
        }
    }
}