package com.chrynan.chat.feature.reaction.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.reaction.adapter.ReactionCategoryItemAdapter
import com.chrynan.chat.feature.reaction.adapter.ReactionListItemAdapter
import com.chrynan.chat.feature.reaction.di.ReactionListFragmentModule
import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.feature.reaction.presenter.ReactionListPresenter
import com.chrynan.chat.feature.reaction.util.DistributeHorizontalEvenlyItemDecoration
import com.chrynan.chat.feature.reaction.view.ReactionListView
import com.chrynan.chat.feature.reaction.viewmodel.ReactionCategoryItemViewModel
import com.chrynan.chat.feature.reaction.viewmodel.ReactionListItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.BaseBottomSheetDialogFragment
import com.chrynan.chat.utils.getDialogParentListenerOrThrow
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_reaction_list.*
import javax.inject.Inject
import javax.inject.Named


class ReactionListFragment : BaseBottomSheetDialogFragment(),
    ReactionListView,
    ReactionListItemAdapter.ReactionSelectedListener,
    ReactionCategoryItemAdapter.ReactionCategorySelectedListener {

    companion object {

        fun newInstance() = ReactionListFragment()
    }

    @Inject
    override lateinit var presenter: ReactionListPresenter

    @Inject
    @field:Named(ReactionListFragmentModule.NAME_REACTION_MANAGER_ADAPTER)
    lateinit var reactionListAdapter: BaseManagerAdapter<AdapterItem>

    @Inject
    @field:Named(ReactionListFragmentModule.NAME_REACTION_LAYOUT_MANAGER)
    lateinit var reactionListLayoutManager: GridLayoutManager

    @Inject
    @field:Named(ReactionListFragmentModule.NAME_CATEGORY_MANAGER_ADAPTER)
    lateinit var categoryListAdapter: BaseManagerAdapter<AdapterItem>

    @Inject
    @field:Named(ReactionListFragmentModule.NAME_CATEGORY_LAYOUT_MANAGER)
    lateinit var categoryListLayoutManager: LinearLayoutManager

    private val peekHeight by lazy { resources.getDimensionPixelSize(R.dimen.reaction_list_dialog_peek_height) }
    private val reactionItemWidth by lazy { resources.getDimensionPixelSize(R.dimen.reaction_list_item_image_size) }

    private lateinit var listener: ReactionEmojiSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = getDialogParentListenerOrThrow()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_reaction_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reactionListRecyclerView?.apply {
            adapter = reactionListAdapter
            layoutManager = reactionListLayoutManager

            addItemDecoration(
                DistributeHorizontalEvenlyItemDecoration(
                    columnCount = 5,
                    itemWidth = reactionItemWidth
                )
            )
        }

        reactionCategoryListRecyclerView?.apply {
            adapter = categoryListAdapter
            layoutManager = categoryListLayoutManager
        }

        view.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View?,
                l: Int,
                t: Int,
                r: Int,
                b: Int,
                oL: Int,
                oT: Int,
                oR: Int,
                oB: Int
            ) {
                view.removeOnLayoutChangeListener(this)
                val behavior = (dialog as? BottomSheetDialog)?.behavior
                behavior?.peekHeight = peekHeight
            }
        })

        presenter.setup()
    }

    override fun onReactionItemSelected(item: ReactionListItemViewModel) {
        listener.onReactionEmojiSelected(item.emoji)
        dismiss()
    }

    override fun onReactionCategorySelected(item: ReactionCategoryItemViewModel) {
        presenter.showCategory(item.category.icon)
    }

    interface ReactionEmojiSelectedListener {

        fun onReactionEmojiSelected(emoji: Emoji)
    }
}