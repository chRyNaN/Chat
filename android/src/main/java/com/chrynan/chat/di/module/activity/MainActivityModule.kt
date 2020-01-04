package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.*
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.*
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

    @FragmentScope
    @ContributesAndroidInjector(modules = [AppInfoFragmentModule::class])
    abstract fun appInfoFragmentInjector(): AppInfoFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [WebFragmentModule::class])
    abstract fun webFragmentInjector(): WebFragment
}