package com.chrynan.chat.di.module.fragment

import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.DiffDispatcher
import com.chrynan.chat.adapter.DiffProcessor
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.adapter.*
import com.chrynan.chat.ui.adapter.processing.AndroidDiffDispatcher
import com.chrynan.chat.ui.adapter.processing.AndroidDiffProcessor
import com.chrynan.chat.ui.fragment.ConversationFragment
import com.chrynan.chat.view.ConversationView
import com.chrynan.chat.viewmodel.MessageListItemViewModel
import com.chrynan.chat.viewmodel.ViewModel
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
        fun provideAdapters(
            headerAdapter: MessageHeaderAdapter,
            dateAdapter: MessageHeaderDateAdapter,
            imageAdapter: MessageImageAdapter,
            reactionAdapter: MessageReactionAdapter,
            statusAdapter: MessageStatusAdapter,
            textAdapter: MessageTextAdapter,
            threadAdapter: MessageThreadAdapter
        ): ManagerRecyclerViewAdapter<MessageListItemViewModel> =
            adapterWith {
                +headerAdapter
                +dateAdapter
                +imageAdapter
                +reactionAdapter
                +statusAdapter
                +textAdapter
                +threadAdapter
            }

        @Provides
        @JvmStatic
        @FragmentScope
        @Named("ReactionAdapter")
        fun provideReactionAdapter(): ManagerRecyclerViewAdapter<ViewModel> = adapterWith { }

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
    abstract fun bindThreadListener(fragment: ConversationFragment): MessageThreadAdapter.MessageThreadListener

    @Binds
    @FragmentScope
    abstract fun bindReactionListener(fragment: ConversationFragment): MessageReactionAdapter.MessageReactionListener

    @Binds
    @FragmentScope
    abstract fun bindDiffProcessor(processor: AndroidDiffProcessor<AdapterItem>): DiffProcessor<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindDiffDispatcher(dispatcher: AndroidDiffDispatcher<AdapterItem>): DiffDispatcher<AdapterItem>
}