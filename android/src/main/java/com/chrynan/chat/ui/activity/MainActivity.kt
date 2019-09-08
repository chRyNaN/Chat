package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.ConversationListFragment
import com.chrynan.chat.ui.fragment.FeedFragment
import com.chrynan.chat.ui.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.bottomNavigationView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFragment(ConversationListFragment.newInstance())

        bottomNavigationView.selectedItemId = R.id.menu_bottom_conversations

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_bottom_feed -> {
                    goToFragment(FeedFragment.newInstance())
                    true
                }
                R.id.menu_bottom_conversations -> {
                    goToFragment(ConversationListFragment.newInstance())
                    true
                }
                R.id.menu_bottom_settings -> {
                    goToFragment(SettingsFragment.newInstance())
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem -> }
    }
}