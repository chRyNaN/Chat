package com.chrynan.chat.feature.settings.di

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.settings.fragment.AppInfoFragment
import com.chrynan.chat.feature.settings.view.AppInfoView
import dagger.Binds

@Module
abstract class AppInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindAppInfoView(fragment: AppInfoFragment): AppInfoView
}