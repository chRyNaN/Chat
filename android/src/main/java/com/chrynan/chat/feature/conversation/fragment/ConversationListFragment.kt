package com.chrynan.chat.feature.conversation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.adapter.ConversationListItemAdapter
import com.chrynan.chat.feature.conversation.binder.ConversationListItemBinder
import com.chrynan.chat.feature.conversation.view.ConversationListView
import com.chrynan.chat.feature.conversation.viewmodel.ConversationListItemViewModel
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.viewmodel.ViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout

class ConversationListFragment : BaseFragment(),
    ConversationListView {

    companion object {

        fun newInstance() =
            ConversationListFragment()
    }

    private val collapsingToolbarLayout
        get() = view!!.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)

    private val titleText by lazy { getString(R.string.app_bar_title_conversations) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout.title = titleText

        val recyclerView = activity!!.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter =
            ManagerRecyclerViewAdapter<ViewModel>(
                adapters = setOf(
                    ConversationListItemAdapter(
                        binder = ConversationListItemBinder()
                    )
                )
            )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter.items = listOf(
            ConversationListItemViewModel(
                conversationId = "",
                title = "Title",
                description = "Description",
                userImage = null,
                formattedDateTime = "Time",
                showNewItemBadge = true
            ),
            ConversationListItemViewModel(
                conversationId = "",
                title = "Title Two",
                description = "Description Two",
                userImage = null,
                formattedDateTime = "Time Two"
            )
        )
    }
}