package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.navigation.core.TabStackNavigator
import com.chrynan.chat.navigation.core.navigatorWith
import com.chrynan.chat.navigation.root.RootTab
import com.chrynan.chat.navigation.root.RootTabFragmentFactory
import com.chrynan.chat.ui.fragment.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.bottomNavigationView) }

    private lateinit var navigator: TabStackNavigator<RootTab, BaseFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = bottomNavigationView.navigatorWith(
            activity = this,
            containerId = R.id.fragmentContainer,
            factory = RootTabFragmentFactory()
        )
    }

    override fun onBackPressed() {
        if (!navigator.goBack()) {
            super.onBackPressed()
        }
    }
}