package com.chrynan.chat.feature.conversation.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.*
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.adapter.AttachmentActionTypeAdapter
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.utils.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class AttachmentActionTypeModule {

    @Module
    companion object {

        const val NAME_DIFF_CALCULATOR = "AttachmentActionTypeDiffCalculator"
        const val NAME_DIFF_PROCESSOR = "AttachmentActionTypeDiffProcessor"
        const val NAME_DIFF_DISPATCHER = "AttachmentActionTypeDiffDispatcher"
        const val NAME_MANAGER_ADAPTER = "AttachmentActionTypeManagerAdapter"
        const val NAME_LAYOUT_MANAGER = "AttachmentActionTypeLayoutManager"
        const val NAME_ADAPTER_ITEM_HANDLER = "AttachmentActionTypeAdapterItemHandler"
        const val NAME_ITEM_LIST_UPDATER = "AttachmentActionTypeAdapterItemListUpdater"

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_DIFF_CALCULATOR)
        fun provideDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_DIFF_PROCESSOR)
        fun provideDiffProcessor(@Named(NAME_DIFF_CALCULATOR) calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_DIFF_DISPATCHER)
        fun provideDiffDispatcher(@Named(NAME_ITEM_LIST_UPDATER) listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_MANAGER_ADAPTER)
        fun provideBaseManagerAdapter(
            @Named(NAME_LAYOUT_MANAGER) layoutManager: LinearLayoutManager,
            attachmentActionTypeAdapter: AttachmentActionTypeAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(attachmentActionTypeAdapter),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_LAYOUT_MANAGER)
        fun provideLayoutManager(context: ActivityContext) =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_ADAPTER_ITEM_HANDLER)
        fun bindAdapterItemHandler(
            coroutineDispatchers: CoroutineDispatchers,
            @Named(NAME_DIFF_PROCESSOR) diffProcessor: DiffProcessor<AdapterItem>,
            @Named(NAME_DIFF_DISPATCHER) diffDispatcher: DiffDispatcher<AdapterItem>
        ): AdapterItemHandler<AdapterItem> = BaseAdapterItemHandler<AdapterItem>(
            diffProcessor = diffProcessor,
            diffDispatcher = diffDispatcher,
            coroutineDispatchers = coroutineDispatchers
        )
    }

    @Binds
    @FragmentScope
    abstract fun bindAttachmentActionTypeSelectedListener(fragment: ConversationFragment): AttachmentActionTypeAdapter.AttachmentActionTypeListener

    @Binds
    @FragmentScope
    @Named(NAME_ITEM_LIST_UPDATER)
    abstract fun bindItemListUpdater(@Named(NAME_MANAGER_ADAPTER) adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>
}