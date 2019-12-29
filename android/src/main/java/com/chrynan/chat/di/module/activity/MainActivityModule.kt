package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.ConversationListFragmentModule
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.ConversationListFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ConversationListFragmentModule::class])
    abstract fun conversationListFragmentInjector(): ConversationListFragment
}