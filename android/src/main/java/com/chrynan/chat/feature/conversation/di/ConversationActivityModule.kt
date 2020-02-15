package com.chrynan.chat.feature.conversation.di

import com.chrynan.chat.di.module.AdapterModule
import com.chrynan.chat.di.module.MediaModule
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.conversation.fragment.ConversationFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class ConversationActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ConversationFragmentModule::class, AdapterModule::class, MediaModule::class])
    abstract fun conversationFragmentInjector(): ConversationFragment
}