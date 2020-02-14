package com.chrynan.chat.feature.contact.activity

import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.ui.fragment.ContactInfoFragment
import com.chrynan.chat.utils.ActivityContext
import kotlinx.android.synthetic.main.layout_fragment_container_with_toolbar.*

class ContactInfoActivity : BaseActivity() {

    companion object {

        private const val KEY_USER_ID = "contactInfoActivityUserIDKey"

        fun newIntent(context: ActivityContext, userID: ID) = Intent(context, ContactInfoActivity::class.java).apply {
            putExtra(KEY_USER_ID, userID)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_fragment_container)
        setSupportActionBar(toolbar)

        val userID = intent.extras?.getString(KEY_USER_ID)!!
        goToFragment(ContactInfoFragment.newInstance(userID = userID), R.id.fragmentContainer)
    }
}