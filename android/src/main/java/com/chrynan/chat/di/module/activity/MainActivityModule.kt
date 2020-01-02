package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.ContactInfoFragmentModule
import com.chrynan.chat.di.module.fragment.ContactListFragmentModule
import com.chrynan.chat.di.module.fragment.ConversationListFragmentModule
import com.chrynan.chat.di.module.fragment.SettingsFragmentModule
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.ContactInfoFragment
import com.chrynan.chat.ui.fragment.ContactListFragment
import com.chrynan.chat.ui.fragment.ConversationListFragment
import com.chrynan.chat.ui.fragment.SettingsFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ConversationListFragmentModule::class])
    abstract fun conversationListFragmentInjector(): ConversationListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ContactListFragmentModule::class])
    abstract fun contactListFragmentInjector(): ContactListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ContactInfoFragmentModule::class])
    abstract fun contactInfoFragmentInjector(): ContactInfoFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SettingsFragmentModule::class])
    abstract fun settingsFragmentInjector(): SettingsFragment
}