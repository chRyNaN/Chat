package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.ConversationFragmentModule
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.ConversationFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class ConversationActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ConversationFragmentModule::class])
    abstract fun conversationFragmentInjector(): ConversationFragment
}