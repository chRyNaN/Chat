package com.chrynan.chat.feature.conversation.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.adapter.message.*
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.feature.conversation.view.ConversationView
import com.chrynan.chat.media.*
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.utils.ActivityContext
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
        fun provideSimpleExoPlayer(context: ActivityContext): SimpleExoPlayer =
            SimpleExoPlayer.Builder(context).build()
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