package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.Reaction
import com.chrynan.chat.presenter.ConversationPresenter
import com.chrynan.chat.ui.adapter.MessageReactionAdapter
import com.chrynan.chat.ui.adapter.MessageThreadAdapter
import com.chrynan.chat.view.ConversationView
import com.chrynan.chat.viewmodel.MessageListItemViewModel
import com.chrynan.chat.viewmodel.MessageReactionItemViewModel
import com.chrynan.chat.viewmodel.MessageThreadItemViewModel

class ConversationFragment : BaseFragment(),
    ConversationView,
    MessageReactionAdapter.MessageReactionListener,
    MessageThreadAdapter.MessageThreadListener {

    companion object {

        fun newInstance() = ConversationFragment()
    }

    @Inject
    override lateinit var presenter: ConversationPresenter

    @Inject
    lateinit var adapter: ManagerRecyclerViewAdapter<MessageListItemViewModel>

    private val recyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recyclerView) }

    private val backgroundColor by lazy { resources.getColor(R.color.colorAccent, null) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        presenter.getInitialMessageItems()
    }

    override fun showMessageItems(items: List<MessageListItemViewModel>) {
        adapter.items = items
    }

    override fun onReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel) {

    }

    override fun onAddReactionSelected(item: MessageReactionItemViewModel) {
    }

    override fun onMessageThreadSelected(item: MessageThreadItemViewModel) {
    }
}