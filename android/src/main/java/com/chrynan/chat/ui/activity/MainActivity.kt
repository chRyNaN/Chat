package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.ContactListFragment
import com.chrynan.chat.feature.conversation.fragment.ConversationListFragment
import com.chrynan.chat.ui.fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFragment(ContactListFragment.newInstance())

        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottom_conversations -> goToFragment(ConversationListFragment.newInstance())
                R.id.menu_bottom_settings -> goToFragment(SettingsFragment.newInstance())
                R.id.menu_bottom_contacts -> goToFragment(ContactListFragment.newInstance())
            }

            true
        }
    }
}