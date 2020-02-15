package com.chrynan.chat.feature.referral.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.referral.navigator.ReferralNavigator
import com.chrynan.chat.feature.referral.view.ReferralView
import com.chrynan.chat.presenter.BasePresenter
import javax.inject.Inject

class ReferralPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: ReferralView,
    private val navigator: ReferralNavigator
) : BasePresenter(dispatchers) {

    companion object {

        private const val INTENT_TYPE = "text/plain"
    }

    fun getMessage() {
        view.showInviteMessage("Chat with me at example@example.com") // TODO load text
    }

    fun handleInviteButtonPress(message: String?) {
        if (message.isNullOrBlank()) {
            view.showNotification(message = "Invite message must not be empty") // TODO load text
        } else {
            navigator.openShareDialog(intentType = INTENT_TYPE, title = "", message = message)
        }
    }
}