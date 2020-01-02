package com.chrynan.chat.di.module.activity

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.module.fragment.OpenSourceLicensesFragmentModule
import com.chrynan.chat.di.module.fragment.WebFragmentModule
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.OpenSourceLicensesFragment
import com.chrynan.chat.ui.fragment.WebFragment
import dagger.android.ContributesAndroidInjector

@Module
abstract class OpenSourceLicensesActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [OpenSourceLicensesFragmentModule::class])
    abstract fun openSourceLicensesInjector(): OpenSourceLicensesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [WebFragmentModule::class])
    abstract fun webFragmentInjector(): WebFragment
}