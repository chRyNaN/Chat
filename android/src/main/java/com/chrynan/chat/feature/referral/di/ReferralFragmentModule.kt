package com.chrynan.chat.feature.referral.di

import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.referral.fragment.ReferralFragment
import com.chrynan.chat.feature.referral.navigator.ReferralNavigator
import com.chrynan.chat.feature.referral.view.ReferralView
import dagger.Binds
import dagger.Module

@Module
abstract class ReferralFragmentModule {

    @FragmentScope
    @Binds
    abstract fun bindReferralView(fragment: ReferralFragment): ReferralView

    @FragmentScope
    @Binds
    abstract fun bindReferralNavigator(fragment: ReferralFragment): ReferralNavigator
}