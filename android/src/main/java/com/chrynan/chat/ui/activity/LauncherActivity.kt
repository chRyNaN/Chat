package com.chrynan.chat.ui.activity

import android.os.Bundle

class LauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.newIntent(this))
    }
}