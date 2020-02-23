package com.chrynan.chat.feature.reaction.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.flowOf
import com.chrynan.chat.coroutines.mapEach
import com.chrynan.chat.coroutines.mapEachWith
import com.chrynan.chat.feature.reaction.di.ReactionListFragmentModule
import com.chrynan.chat.feature.reaction.mapper.ReactionCategoryMapper
import com.chrynan.chat.feature.reaction.mapper.ReactionEmojiMapper
import com.chrynan.chat.feature.reaction.model.EmojiCategory
import com.chrynan.chat.feature.reaction.view.ReactionListView
import com.chrynan.chat.presenter.BasePresenter
import com.chrynan.chat.repository.EmojiRepository
import com.chrynan.chat.resources.ResourceID
import com.chrynan.chat.utils.calculateAndDispatchDiff
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

class ReactionListPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    @Named(ReactionListFragmentModule.NAME_REACTION_ADAPTER_ITEM_HANDLER) private val reactionItemHandler: AdapterItemHandler<AdapterItem>,
    @Named(ReactionListFragmentModule.NAME_CATEGORY_ADAPTER_ITEM_HANDLER) private val categoryItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ReactionListView,
    private val emojiRepository: EmojiRepository,
    private val reactionMapper: ReactionEmojiMapper,
    private val categoryMapper: ReactionCategoryMapper
) : BasePresenter(dispatchers = dispatchers) {

    private var categories: List<EmojiCategory> = emptyList()
    private var selectedCategory: EmojiCategory? = null

    fun setup() {
        flowOf { emojiRepository.getCategories() }
            .onEach { categories = it }
            .onEach { selectedCategory = it.firstOrNull() }
            .mapEach {
                val categoryViewModel = categoryMapper.map(it)

                categoryViewModel.copy(isSelected = categoryViewModel.category == selectedCategory)
            }
            .calculateAndDispatchDiff(categoryItemHandler)
            .mapNotNull {
                selectedCategory?.emojis?.map { reactionMapper.map(it) }
            }
            .calculateAndDispatchDiff(reactionItemHandler)
            .launchIn(this)
    }

    fun showCategory(resourceID: ResourceID) {
        val category = categories.firstOrNull { it.icon == resourceID }

        if (category != null) {
            selectedCategory = category

            flowOf { categories }
                .mapEach {
                    val categoryViewModel = categoryMapper.map(it)

                    categoryViewModel.copy(isSelected = categoryViewModel.category == selectedCategory)
                }
                .calculateAndDispatchDiff(categoryItemHandler)
                .map { category.emojis }
                .mapEachWith(reactionMapper)
                .calculateAndDispatchDiff(reactionItemHandler)
                .launchIn(this)
        }
    }
}