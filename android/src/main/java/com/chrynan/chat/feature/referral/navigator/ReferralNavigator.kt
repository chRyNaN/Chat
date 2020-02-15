package com.chrynan.chat.feature.referral.navigator

import com.chrynan.chat.navigator.Navigator

interface ReferralNavigator : Navigator {

    fun openShareDialog(intentType: String, title: String? = null, message: String)
}