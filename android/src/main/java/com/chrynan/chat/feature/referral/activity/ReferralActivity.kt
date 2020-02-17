package com.chrynan.chat.feature.referral.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.feature.referral.fragment.ReferralFragment
import com.chrynan.chat.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.layout_fragment_container_with_toolbar.*

class ReferralActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, ReferralActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referral)
        goToFragment(ReferralFragment.newInstance())

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbar?.apply {
            navigationIcon = getDrawable(R.drawable.ic_toolbar_close)
            setNavigationOnClickListener { goBack() }
        }
    }
}