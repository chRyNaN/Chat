package com.chrynan.chat.feature.conversation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.feature.conversation.view.ConversationToolbarView
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_conversation.*

class ConversationActivity : BaseActivity(),
    ConversationToolbarView {

    companion object {

        fun newIntent(context: Context) = Intent(context, ConversationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        setSupportActionBar(conversationToolbar)

        conversationToolbar?.setNavigationOnClickListener { goBack() }

        goToFragment(ConversationFragment.newInstance())
    }

    override fun showUserImage(userImage: UserImage) {
        conversationToolbarUserImageView?.visibility = View.VISIBLE
        conversationToolbarUserImageView?.userImage = userImage
    }

    override fun hideUserImage() {
        conversationToolbarUserImageView?.visibility = View.GONE
        conversationToolbarUserImageView?.userImage = null
    }

    override fun showTitle(title: String) {
        conversationToolbarTitleTextView?.visibility = View.VISIBLE
        conversationToolbarTitleTextView?.text = title
    }

    override fun hideTitle() {
        conversationToolbarTitleTextView?.visibility = View.GONE
        conversationToolbarTitleTextView?.text = null
    }
}