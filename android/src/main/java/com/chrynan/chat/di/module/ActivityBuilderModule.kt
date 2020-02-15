package com.chrynan.chat.di.module

import com.chrynan.chat.di.module.activity.LauncherActivityModule
import com.chrynan.chat.di.module.activity.MainActivityModule
import com.chrynan.chat.di.module.activity.SignInActivityModule
import com.chrynan.chat.di.module.activity.WebActivityModule
import com.chrynan.chat.di.scope.ActivityScope
import com.chrynan.chat.feature.contact.activity.ContactInfoActivity
import com.chrynan.chat.feature.contact.di.ContactInfoActivityModule
import com.chrynan.chat.feature.conversation.activity.ConversationActivity
import com.chrynan.chat.feature.conversation.di.ConversationActivityModule
import com.chrynan.chat.feature.media.activity.MediaPreviewActivity
import com.chrynan.chat.feature.media.di.MediaPreviewActivityModule
import com.chrynan.chat.feature.referral.activity.ReferralActivity
import com.chrynan.chat.feature.referral.di.ReferralActivityModule
import com.chrynan.chat.feature.settings.activity.OpenSourceLicensesActivity
import com.chrynan.chat.feature.settings.di.OpenSourceLicensesActivityModule
import com.chrynan.chat.ui.activity.LauncherActivity
import com.chrynan.chat.ui.activity.MainActivity
import com.chrynan.chat.ui.activity.SignInActivity
import com.chrynan.chat.ui.activity.WebActivity
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

    @ActivityScope
    @ContributesAndroidInjector(modules = [ContactInfoActivityModule::class])
    abstract fun contactInfoActivityInjector(): ContactInfoActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MediaPreviewActivityModule::class])
    abstract fun mediaPreviewActivityInjector(): MediaPreviewActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ReferralActivityModule::class])
    abstract fun referralActivityInjector(): ReferralActivity
}