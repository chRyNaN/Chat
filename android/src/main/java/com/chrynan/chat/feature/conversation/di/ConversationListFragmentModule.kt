package com.chrynan.chat.feature.conversation.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.*
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.adapter.ConversationListItemAdapter
import com.chrynan.chat.feature.conversation.fragment.ConversationListFragment
import com.chrynan.chat.feature.conversation.view.ConversationListView
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.utils.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ConversationListFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideDiffProcessor(calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideDiffDispatcher(listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideBaseManagerAdapter(
            layoutManager: LinearLayoutManager,
            conversationListItemAdapter: ConversationListItemAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(conversationListItemAdapter),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context)

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideAdapterItemHandler(
            coroutineDispatchers: CoroutineDispatchers,
            diffProcessor: DiffProcessor<AdapterItem>,
            diffDispatcher: DiffDispatcher<AdapterItem>
        ): AdapterItemHandler<AdapterItem> = BaseAdapterItemHandler<AdapterItem>(
            diffProcessor = diffProcessor,
            diffDispatcher = diffDispatcher,
            coroutineDispatchers = coroutineDispatchers
        )
    }

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindConversationListView(fragment: ConversationListFragment): ConversationListView

    @Binds
    @FragmentScope
    abstract fun bindConversationListItemSelectedListener(fragment: ConversationListFragment): ConversationListItemAdapter.ConversationListItemSelectedListener
}