package com.chrynan.chat.di.module.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.*
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.media.*
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.adapter.message.*
import com.chrynan.chat.ui.adapter.processing.AndroidDiffDispatcher
import com.chrynan.chat.ui.adapter.processing.AndroidDiffProcessor
import com.chrynan.chat.ui.fragment.ConversationFragment
import com.chrynan.chat.utils.ActivityContext
import com.chrynan.chat.view.ConversationView
import com.google.android.exoplayer2.SimpleExoPlayer
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
            videoAdapter: MessageVideoAdapter,
            imageAdapter: MessageImageAdapter,
            fileAdapter: MessageFileAdapter,
            typingAdapter: MessageTypingAdapter
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
                    typingAdapter
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

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideAaaahDiffProcessor(): com.chrynan.aaaah.DiffProcessor<AdapterItem> =
            com.chrynan.aaaah.DiffProcessor()

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideSimpleExoPlayer(context: ActivityContext): SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()
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
    abstract fun bindMessageImageSelectedListener(fragment: ConversationFragment): MessageImageAdapter.ImageSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindMessageFileSelectedListener(fragment: ConversationFragment): MessageFileAdapter.FileSelectedListener

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

    @Binds
    @FragmentScope
    abstract fun bindListMediaPlayerViewController(controller: MediaPlayerViewQueueController): MediaPlayerViewController

    @Binds
    @FragmentScope
    abstract fun bindMediaSourceCreator(creator: AndroidMediaSourceCreator): MediaSourceCreator

    @Binds
    @FragmentScope
    abstract fun bindMediaController(controller: SimpleExoPlayerMediaController): MediaController
}