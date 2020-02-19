package com.chrynan.chat.feature.reaction.di

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.*
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.scope.DialogFragmentScope
import com.chrynan.chat.feature.reaction.adapter.ReactionCategoryItemAdapter
import com.chrynan.chat.feature.reaction.adapter.ReactionListItemAdapter
import com.chrynan.chat.feature.reaction.fragment.ReactionListFragment
import com.chrynan.chat.feature.reaction.view.ReactionListView
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.utils.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class ReactionListFragmentModule {

    @Module
    companion object {

        private const val NAME_REACTION_DIFF_CALCULATOR = "ReactionListDiffCalculator"
        private const val NAME_REACTION_DIFF_PROCESSOR = "ReactionListDiffProcessor"
        private const val NAME_REACTION_DIFF_DISPATCHER = "ReactionListDiffDispatcher"
        const val NAME_REACTION_MANAGER_ADAPTER = "ReactionListManagerAdapter"
        const val NAME_REACTION_LAYOUT_MANAGER = "ReactionListLayoutManager"
        const val NAME_REACTION_ADAPTER_ITEM_HANDLER = "ReactionListAdapterItemHandler"
        const val NAME_REACTION_ITEM_LIST_UPDATER = "ReactionListItemListUpdater"

        private const val NAME_CATEGORY_DIFF_CALCULATOR = "ReactionCategoryListDiffCalculator"
        private const val NAME_CATEGORY_DIFF_PROCESSOR = "ReactionCategoryListDiffProcessor"
        private const val NAME_CATEGORY_DIFF_DISPATCHER = "ReactionCategoryListDiffDispatcher"
        const val NAME_CATEGORY_MANAGER_ADAPTER = "ReactionCategoryListManagerAdapter"
        const val NAME_CATEGORY_LAYOUT_MANAGER = "ReactionCategoryListLayoutManager"
        const val NAME_CATEGORY_ADAPTER_ITEM_HANDLER = "ReactionCategoryListAdapterItemHandler"
        const val NAME_CATEGORY_ITEM_LIST_UPDATER = "ReactionCategoryListItemListUpdater"

        // Reaction

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_DIFF_CALCULATOR)
        fun provideDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_DIFF_PROCESSOR)
        fun provideDiffProcessor(@Named(NAME_REACTION_DIFF_CALCULATOR) calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_DIFF_DISPATCHER)
        fun provideDiffDispatcher(@Named(NAME_REACTION_ITEM_LIST_UPDATER) listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_MANAGER_ADAPTER)
        fun provideBaseManagerAdapter(
            reactionAdapter: ReactionListItemAdapter,
            @Named(NAME_REACTION_LAYOUT_MANAGER) layoutManager: GridLayoutManager
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(setOf(reactionAdapter), layoutManager)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_LAYOUT_MANAGER)
        fun provideLayoutManager(context: ActivityContext) = GridLayoutManager(context, 5)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_REACTION_ADAPTER_ITEM_HANDLER)
        fun provideAdapterHandler(
            @Named(NAME_REACTION_DIFF_PROCESSOR) processor: DiffProcessor<AdapterItem>,
            @Named(NAME_REACTION_DIFF_DISPATCHER) dispatcher: DiffDispatcher<AdapterItem>,
            coroutineDispatchers: CoroutineDispatchers
        ): AdapterItemHandler<AdapterItem> = BaseAdapterItemHandler(
            diffProcessor = processor,
            diffDispatcher = dispatcher,
            coroutineDispatchers = coroutineDispatchers
        )

        // Category

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_DIFF_CALCULATOR)
        fun provideCategoryDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_DIFF_PROCESSOR)
        fun provideCategoryDiffProcessor(@Named(NAME_CATEGORY_DIFF_CALCULATOR) calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_DIFF_DISPATCHER)
        fun provideCategoryDiffDispatcher(@Named(NAME_CATEGORY_ITEM_LIST_UPDATER) listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_MANAGER_ADAPTER)
        fun provideCategoryBaseManagerAdapter(
            categoryAdapter: ReactionCategoryItemAdapter,
            @Named(NAME_CATEGORY_LAYOUT_MANAGER) layoutManager: LinearLayoutManager
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(setOf(categoryAdapter), layoutManager)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_LAYOUT_MANAGER)
        fun provideCategoryLayoutManager(context: ActivityContext) =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        @Provides
        @JvmStatic
        @DialogFragmentScope
        @Named(NAME_CATEGORY_ADAPTER_ITEM_HANDLER)
        fun provideCategoryAdapterHandler(
            @Named(NAME_CATEGORY_DIFF_PROCESSOR) processor: DiffProcessor<AdapterItem>,
            @Named(NAME_CATEGORY_DIFF_DISPATCHER) dispatcher: DiffDispatcher<AdapterItem>,
            coroutineDispatchers: CoroutineDispatchers
        ): AdapterItemHandler<AdapterItem> = BaseAdapterItemHandler(
            diffProcessor = processor,
            diffDispatcher = dispatcher,
            coroutineDispatchers = coroutineDispatchers
        )
    }

    @Binds
    @DialogFragmentScope
    @Named(NAME_REACTION_ITEM_LIST_UPDATER)
    abstract fun bindItemListUpdater(@Named(NAME_REACTION_MANAGER_ADAPTER) adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @DialogFragmentScope
    @Named(NAME_CATEGORY_ITEM_LIST_UPDATER)
    abstract fun bindCategoryItemListUpdater(@Named(NAME_CATEGORY_MANAGER_ADAPTER) adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @DialogFragmentScope
    abstract fun bindReactionListView(fragment: ReactionListFragment): ReactionListView

    @Binds
    @DialogFragmentScope
    abstract fun bindReactionSelectedListener(fragment: ReactionListFragment): ReactionListItemAdapter.ReactionSelectedListener

    @Binds
    @DialogFragmentScope
    abstract fun bindReactionCategorySelectedListener(fragment: ReactionListFragment): ReactionCategoryItemAdapter.ReactionCategorySelectedListener
}