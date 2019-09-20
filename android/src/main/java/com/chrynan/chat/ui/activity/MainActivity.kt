package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.navigation.core.viewmodel.getTabStackNavigatorWith
import com.chrynan.chat.navigation.root.RootTab
import com.chrynan.chat.navigation.root.RootTabFragmentFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.bottomNavigationView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigator = getTabStackNavigatorWith(
            activity = this,
            containerId = R.id.fragmentContainer,
            factory = RootTabFragmentFactory()
        )

        bottomNavigationView.selectedItemId = R.id.menu_bottom_conversations

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val tab = RootTab.fromId(menuItem.itemId)

            tab?.let {
                navigator.switchTab(tab = it)
                true
            } ?: false
        }
        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem ->
            val tab = RootTab.fromId(menuItem.itemId)

            tab?.let {
                navigator.switchTab(tab = it)
            }
        }
    }
}