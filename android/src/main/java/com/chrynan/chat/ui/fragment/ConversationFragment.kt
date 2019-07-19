package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.R
import com.chrynan.chat.model.HorizontalPosition
import com.chrynan.chat.ui.adapter.TextMessageListItemAdapter
import com.chrynan.chat.viewmodel.TextMessageListItemViewModel
import com.chrynan.chat.viewmodel.ViewModel

class ConversationFragment : BaseFragment() {

    companion object {

        fun newInstance() = ConversationFragment()
    }

    private val toolbar by lazy { view!!.findViewById<Toolbar>(R.id.toolbar) }
    private val recyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recyclerView) }

    private val backgroundColor by lazy { resources.getColor(R.color.colorAccent, null) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = "Conversation"

        val textMessageAdapter = TextMessageListItemAdapter()
        val adapter =
            ManagerRecyclerViewAdapter<ViewModel>(
                adapters = setOf(
                    textMessageAdapter.startAdapter(),
                    textMessageAdapter.endAdapter()
                )
            )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter.items = listOf(
            TextMessageListItemViewModel(
                messageID = "",
                formattedTime = "",
                text = "Start Position",
                side = HorizontalPosition.START,
                backgroundColorInt = backgroundColor
            ),
            TextMessageListItemViewModel(
                messageID = "",
                formattedTime = "",
                text = "Another Start Position but with a longer text to test it going to the next line.",
                side = HorizontalPosition.START,
                backgroundColorInt = backgroundColor
            ),
            TextMessageListItemViewModel(
                messageID = "",
                formattedTime = "",
                text = "End Position",
                side = HorizontalPosition.END,
                backgroundColorInt = backgroundColor
            )
        )
    }
}