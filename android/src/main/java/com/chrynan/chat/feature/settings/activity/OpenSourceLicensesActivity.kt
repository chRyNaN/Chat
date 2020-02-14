package com.chrynan.chat.feature.settings.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.feature.settings.fragment.OpenSourceLicensesFragment
import com.chrynan.chat.ui.activity.BaseActivity

class OpenSourceLicensesActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, OpenSourceLicensesActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_source_licenses)
        goToFragment(OpenSourceLicensesFragment.newInstance())
    }
}