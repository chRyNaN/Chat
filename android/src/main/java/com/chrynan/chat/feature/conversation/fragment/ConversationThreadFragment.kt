package com.chrynan.chat.feature.conversation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.view.ConversationThreadView
import com.chrynan.chat.ui.fragment.BaseFragment

class ConversationThreadFragment : BaseFragment(),
    ConversationThreadView {

    companion object {

        fun newInstance() = ConversationThreadFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation_thread, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}