package com.chrynan.chat.feature.reaction.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.reaction.model.load
import com.chrynan.chat.feature.reaction.viewmodel.ReactionListItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_reaction_selection.view.*
import javax.inject.Inject

@Adapter
class ReactionListItemAdapter @Inject constructor(private val listener: ReactionSelectedListener) :
    BaseAdapter<ReactionListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ReactionListItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_reaction_selection,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ReactionListItemViewModel) {
        view.apply {
            reactionEmojiImageView?.load(item.emoji)
            reactionEmojiImageView?.setOnClickListener { listener.onReactionItemSelected(item) }
        }
    }

    interface ReactionSelectedListener {

        fun onReactionItemSelected(item: ReactionListItemViewModel)
    }
}