package com.chrynan.chat.feature.conversation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.conversation.activity.ConversationActivity
import com.chrynan.chat.feature.conversation.adapter.ConversationListItemAdapter
import com.chrynan.chat.feature.conversation.presenter.ConversationListPresenter
import com.chrynan.chat.feature.conversation.view.ConversationListView
import com.chrynan.chat.feature.conversation.viewmodel.ConversationListItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_conversation_list.*
import kotlinx.android.synthetic.main.layout_collapsing_app_bar.*
import javax.inject.Inject

class ConversationListFragment : BaseFragment(),
    ConversationListView,
    ConversationListItemAdapter.ConversationListItemSelectedListener {

    companion object {

        fun newInstance() =
            ConversationListFragment()
    }

    @Inject
    override lateinit var presenter: ConversationListPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    private val titleText by lazy { getString(R.string.app_bar_title_conversations) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout?.title = titleText

        conversationListRecyclerView.adapter = adapter
        conversationListRecyclerView.layoutManager = layoutManager

        conversationListSwipeRefreshLayout?.setOnRefreshListener {
            presenter.loadMore()
        }

        conversationListNewFab?.setOnClickListener { }

        presenter.loadItems()
    }

    override fun toggleLoading(isLoading: Boolean) {
        conversationListSwipeRefreshLayout?.isRefreshing = isLoading
    }

    override fun onConversationListItemSelected(item: ConversationListItemViewModel) {
        startActivity(ConversationActivity.newIntent(context!!))
    }
}