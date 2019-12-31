package com.chrynan.chat.di.module.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.*
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.adapter.*
import com.chrynan.chat.ui.adapter.processing.AndroidDiffDispatcher
import com.chrynan.chat.ui.adapter.processing.AndroidDiffProcessor
import com.chrynan.chat.ui.fragment.ConversationFragment
import com.chrynan.chat.utils.ActivityContext
import com.chrynan.chat.view.ConversationView
import dagger.Binds
import dagger.Provides
import javax.inject.Named

@Module
abstract class ConversationFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideBaseManagerAdapter(
            layoutManager: LinearLayoutManager,
            headerAdapter: MessageHeaderAdapter,
            dateAdapter: MessageHeaderDateAdapter,
            textAdapter: MessageTextAdapter,
            actionAdapter: MessageActionAdapter,
            linkAdapter: MessageLinkPreviewAdapter,
            attachmentAdapter: MessageAttachmentAdapter,
            typingAdapter: MessageTypingAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(
                    headerAdapter,
                    dateAdapter,
                    textAdapter,
                    actionAdapter,
                    linkAdapter,
                    attachmentAdapter,
                    typingAdapter
                ),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context)

        @Provides
        @JvmStatic
        @FragmentScope
        @Named("ReactionAdapter")
        fun provideReactionAdapter(layoutManager: LinearLayoutManager): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(adapters = setOf(), layoutManager = layoutManager)

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideAaaahDiffProcessor(): com.chrynan.aaaah.DiffProcessor<AdapterItem> =
            com.chrynan.aaaah.DiffProcessor()
    }

    @Binds
    @FragmentScope
    abstract fun bindConversationView(fragment: ConversationFragment): ConversationView

    @Binds
    @FragmentScope
    abstract fun bindThreadListener(fragment: ConversationFragment): MessageActionAdapter.MessageActionListener

    @Binds
    @FragmentScope
    abstract fun bindLinkPreviewListener(fragment: ConversationFragment): MessageLinkPreviewAdapter.LinkPreviewListener

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindDiffProcessor(processor: AndroidDiffProcessor<AdapterItem>): DiffProcessor<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindDiffDispatcher(dispatcher: AndroidDiffDispatcher<AdapterItem>): DiffDispatcher<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindAdapterItemHandler(handler: BaseAdapterItemHandler<AdapterItem>): AdapterItemHandler<AdapterItem>
}