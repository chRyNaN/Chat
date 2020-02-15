package com.chrynan.chat.feature.referral.di

import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.referral.fragment.ReferralFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ReferralActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ReferralFragmentModule::class])
    abstract fun referralFragmentInjector(): ReferralFragment
}