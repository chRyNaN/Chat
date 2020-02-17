package com.chrynan.chat.feature.conversation.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.*
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.adapter.message.*
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.feature.conversation.view.ConversationView
import com.chrynan.chat.feature.conversation.view.MessageEditorView
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.utils.ActivityContext
import dagger.Binds
import dagger.Provides
import javax.inject.Named

@Module
abstract class ConversationFragmentModule {

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideDiffProcessor(calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideDiffDispatcher(listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)

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
            videoAdapter: MessageVideoAdapter,
            imageAdapter: MessageImageAdapter,
            fileAdapter: MessageFileAdapter,
            typingAdapter: MessageTypingAdapter,
            notificationAdapter: MessageNotificationAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(
                    headerAdapter,
                    dateAdapter,
                    textAdapter,
                    actionAdapter,
                    linkAdapter,
                    videoAdapter,
                    imageAdapter,
                    fileAdapter,
                    typingAdapter,
                    notificationAdapter
                ),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context).apply {
            stackFromEnd = true
        }

        @Provides
        @JvmStatic
        @FragmentScope
        @Named("ReactionAdapter")
        fun provideReactionAdapter(layoutManager: LinearLayoutManager): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(),
                layoutManager = layoutManager
            )
    }

    @Binds
    @FragmentScope
    abstract fun bindConversationView(fragment: ConversationFragment): ConversationView

    @Binds
    @FragmentScope
    abstract fun bindMessageEditorView(fragment: ConversationFragment): MessageEditorView

    @Binds
    @FragmentScope
    abstract fun bindThreadListener(fragment: ConversationFragment): MessageActionAdapter.MessageActionListener

    @Binds
    @FragmentScope
    abstract fun bindLinkPreviewListener(fragment: ConversationFragment): MessageLinkPreviewAdapter.LinkPreviewListener

    @Binds
    @FragmentScope
    abstract fun bindMessageImageSelectedListener(fragment: ConversationFragment): MessageImageAdapter.ImageSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindMessageFileSelectedListener(fragment: ConversationFragment): MessageFileAdapter.FileSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindAdapterItemHandler(handler: BaseAdapterItemHandler<AdapterItem>): AdapterItemHandler<AdapterItem>
}