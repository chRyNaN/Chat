package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.ConversationFragment

class ConversationActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, ConversationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        goToFragment(ConversationFragment.newInstance())
    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.let {
            it.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragment)

                commitNow()
            }
        }
    }
}