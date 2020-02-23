package com.chrynan.chat.feature.conversation.di

import com.chrynan.chat.di.module.MediaModule
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.ActivityScope
import com.chrynan.chat.di.scope.DialogFragmentScope
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.activity.ConversationActivity
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import com.chrynan.chat.feature.conversation.view.ConversationToolbarView
import com.chrynan.chat.feature.reaction.di.ReactionListFragmentModule
import com.chrynan.chat.feature.reaction.fragment.ReactionListFragment
import dagger.Binds
import dagger.android.ContributesAndroidInjector

@Module
abstract class ConversationActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            ConversationFragmentModule::class,
            MediaModule::class,
            AttachmentActionTypeModule::class,
            AttachmentGalleryModule::class,
            MessageReactionListModule::class]
    )
    abstract fun conversationFragmentInjector(): ConversationFragment

    @DialogFragmentScope
    @ContributesAndroidInjector(modules = [ReactionListFragmentModule::class])
    abstract fun reactionListFragmentInjector(): ReactionListFragment

    @Binds
    @ActivityScope
    abstract fun bindConversationToolbarView(activity: ConversationActivity): ConversationToolbarView
}