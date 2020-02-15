package com.chrynan.chat.feature.referral.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.feature.referral.activity.ReferralActivity
import com.chrynan.chat.feature.referral.navigator.ReferralNavigator
import com.chrynan.chat.feature.referral.presenter.ReferralPresenter
import com.chrynan.chat.feature.referral.view.ReferralView
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.utils.snackbarOf
import com.chrynan.chat.view.NotificationView
import kotlinx.android.synthetic.main.fragment_referral.*
import javax.inject.Inject

class ReferralFragment : BaseFragment(),
    ReferralView,
    ReferralNavigator {

    companion object {

        fun newInstance() = ReferralFragment()
    }

    @Inject
    override lateinit var presenter: ReferralPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_referral, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getMessage()

        referralInviteButton?.setOnClickListener { presenter.handleInviteButtonPress(message = referralMessageTextInputEditText?.text?.toString()) }
    }

    override fun showNotification(
        message: String,
        type: NotificationView.Type,
        length: NotificationView.Length,
        action: NotificationView.Action?
    ) {
        snackbarOf(referralConstraintLayout, message, type, length).show()
    }

    override fun showInviteMessage(message: String) {
        referralMessageTextInputEditText?.setText(message)
    }

    override fun openShareDialog(intentType: String, title: String?, message: String) {
        val inviteIntent = Intent(Intent.ACTION_SEND)
            .setType(intentType)
            .putExtra(Intent.EXTRA_TEXT, message)

        startActivity(Intent.createChooser(inviteIntent, title))
    }

    override fun goBack() {
        (activity as? ReferralActivity)?.goBack()
    }
}