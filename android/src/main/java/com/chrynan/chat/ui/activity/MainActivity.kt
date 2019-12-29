package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.ConversationListFragment

class MainActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFragment(ConversationListFragment.newInstance())
    }
}