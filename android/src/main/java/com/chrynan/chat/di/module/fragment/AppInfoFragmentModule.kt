package com.chrynan.chat.di.module.fragment

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.AppInfoFragment
import com.chrynan.chat.view.AppInfoView
import dagger.Binds

@Module
abstract class AppInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindAppInfoView(fragment: AppInfoFragment): AppInfoView
}