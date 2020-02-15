package com.chrynan.chat.feature.referral.view

import com.chrynan.chat.view.NotificationView
import com.chrynan.chat.view.View

interface ReferralView : View,
    NotificationView {

    fun showInviteMessage(message: String)
}