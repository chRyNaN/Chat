package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.Reaction
import com.chrynan.chat.presenter.ConversationPresenter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.adapter.message.MessageActionAdapter
import com.chrynan.chat.ui.adapter.message.MessageFileAdapter
import com.chrynan.chat.ui.adapter.message.MessageImageAdapter
import com.chrynan.chat.ui.adapter.message.MessageLinkPreviewAdapter
import com.chrynan.chat.view.ConversationView
import com.chrynan.chat.viewmodel.*
import kotlinx.android.synthetic.main.fragment_conversation.*

class ConversationFragment : BaseFragment(),
    ConversationView,
    MessageActionAdapter.MessageActionListener,
    MessageLinkPreviewAdapter.LinkPreviewListener,
    MessageImageAdapter.ImageSelectedListener,
    MessageFileAdapter.FileSelectedListener {

    companion object {

        fun newInstance() = ConversationFragment()
    }

    @Inject
    override lateinit var presenter: ConversationPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = layoutManager

        presenter.getInitialMessageItems()
    }

    override fun showMessageItems(items: List<MessageListItemViewModel>) {
        adapter.items = items
    }

    override fun onRemoveReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel) {

    }

    override fun onAddReactionSelected(
        reaction: Reaction,
        item: MessageReactionItemViewModel
    ) {
    }

    override fun onMessageThreadSelected(item: MessageActionItemViewModel) {
    }

    override fun onLinkPreviewSelected(item: MessageLinkPreviewItemViewModel) {

    }

    override fun onImageSelected(item: MessageImageItemViewModel) {

    }

    override fun onFileSelected(item: MessageFileItemViewModel) {

    }
}