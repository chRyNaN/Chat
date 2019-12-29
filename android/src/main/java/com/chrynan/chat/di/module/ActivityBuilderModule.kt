package com.chrynan.chat.di.module

import com.chrynan.chat.di.module.activity.*
import com.chrynan.chat.di.scope.ActivityScope
import com.chrynan.chat.ui.activity.*
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LauncherActivityModule::class])
    abstract fun launcherActivityInjector(): LauncherActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ConversationActivityModule::class])
    abstract fun conversationActivityInjector(): ConversationActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [OpenSourceLicensesActivityModule::class])
    abstract fun openSourceLicensesActivityInjector(): OpenSourceLicensesActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SignInActivityModule::class])
    abstract fun signInActivityInjector(): SignInActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [WebActivityModule::class])
    abstract fun webActivityInjector(): WebActivity
}