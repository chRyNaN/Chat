package com.chrynan.chat.feature.conversation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.layout_fragment_container_with_toolbar.*

class ConversationActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, ConversationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_fragment_container_with_toolbar)
        setSupportActionBar(toolbar)
        goToFragment(ConversationFragment.newInstance())
    }
}