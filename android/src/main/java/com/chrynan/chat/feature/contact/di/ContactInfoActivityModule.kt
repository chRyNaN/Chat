package com.chrynan.chat.feature.contact.di

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.ContactInfoFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContactInfoActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ContactInfoFragmentModule::class])
    abstract fun contactInfoFragmentInjector(): ContactInfoFragment
}