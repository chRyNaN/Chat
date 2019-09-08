package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.WebFragment

class WebActivity : BaseActivity() {

    companion object {

        private const val KEY_URL = "keyUrl"

        fun newIntent(context: Context, url: String) =
            Intent(context, WebActivity::class.java).apply {
                putExtra(KEY_URL, url)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        intent.extras?.getString(KEY_URL)?.let {
            goToFragment(WebFragment.newInstance(url = it))
        }
    }
}