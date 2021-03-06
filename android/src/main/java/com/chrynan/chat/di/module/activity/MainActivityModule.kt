package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.AdapterModule
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.*
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.contact.di.ContactInfoFragmentModule
import com.chrynan.chat.feature.contact.di.ContactListFragmentModule
import com.chrynan.chat.feature.contact.fragment.ContactInfoFragment
import com.chrynan.chat.feature.contact.fragment.ContactListFragment
import com.chrynan.chat.feature.conversation.di.ConversationListFragmentModule
import com.chrynan.chat.feature.conversation.fragment.ConversationListFragment
import com.chrynan.chat.feature.settings.di.AppInfoFragmentModule
import com.chrynan.chat.feature.settings.di.SettingsFragmentModule
import com.chrynan.chat.feature.settings.fragment.AppInfoFragment
import com.chrynan.chat.feature.settings.fragment.SettingsFragment
import com.chrynan.chat.ui.fragment.*
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ConversationListFragmentModule::class])
    abstract fun conversationListFragmentInjector(): ConversationListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ContactListFragmentModule::class, AdapterModule::class])
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