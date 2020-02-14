package com.chrynan.chat.feature.settings.di

import com.chrynan.chat.di.module.AdapterModule
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.WebFragmentModule
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.settings.di.OpenSourceLicensesFragmentModule
import com.chrynan.chat.feature.settings.fragment.OpenSourceLicensesFragment
import com.chrynan.chat.ui.fragment.WebFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class OpenSourceLicensesActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [OpenSourceLicensesFragmentModule::class, AdapterModule::class])
    abstract fun openSourceLicensesInjector(): OpenSourceLicensesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [WebFragmentModule::class])
    abstract fun webFragmentInjector(): WebFragment
}