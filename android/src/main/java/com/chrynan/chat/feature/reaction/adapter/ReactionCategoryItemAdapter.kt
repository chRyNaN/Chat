package com.chrynan.chat.feature.reaction.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.reaction.viewmodel.ReactionCategoryItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_reaction_category.view.*
import javax.inject.Inject

@Adapter
class ReactionCategoryItemAdapter @Inject constructor(private val listener: ReactionCategorySelectedListener) :
    BaseAdapter<ReactionCategoryItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ReactionCategoryItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_reaction_category,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ReactionCategoryItemViewModel) {
        view.apply {
            reactionCategoryIconImageView?.load(item.category.icon)
            reactionCategoryIconImageView?.isActivated = item.isSelected
            reactionCategoryIconImageView?.setOnClickListener {
                listener.onReactionCategorySelected(
                    item
                )
            }
        }
    }

    interface ReactionCategorySelectedListener {

        fun onReactionCategorySelected(item: ReactionCategoryItemViewModel)
    }
}