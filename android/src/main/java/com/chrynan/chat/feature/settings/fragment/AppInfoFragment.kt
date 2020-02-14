package com.chrynan.chat.feature.settings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.model.ColorInt
import com.chrynan.chat.feature.settings.presenter.AppInfoPresenter
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.feature.settings.view.AppInfoView
import kotlinx.android.synthetic.main.fragment_app_info.*
import kotlinx.android.synthetic.main.layout_app_info_cell.view.*
import javax.inject.Inject

class AppInfoFragment : BaseFragment(),
    AppInfoView {

    companion object {

        fun newInstance() =
            AppInfoFragment()
    }

    @Inject
    override lateinit var presenter: AppInfoPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_app_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        versionUpdateCell?.setOnClickListener { }
        licenseCell?.setOnClickListener { }
        sourceCodeCell?.setOnClickListener { }

        presenter.getInfo()
    }

    override fun showVersion(label: String, version: String) {
        versionCell?.visibility = View.VISIBLE
        versionCell?.labelTextView?.text = label
        versionCell?.contentTextView?.text = version
    }

    override fun hideVersion() {
        versionCell?.visibility = View.GONE
    }

    override fun showUpdateAvailable(
        label: String,
        updateDescription: String,
        descriptionColorInt: ColorInt
    ) {
        versionUpdateCell?.visibility = View.VISIBLE
        versionUpdateCell?.labelTextView?.text = label
        versionUpdateCell?.contentTextView?.text = updateDescription
        versionUpdateCell?.contentTextView?.setTextColor(descriptionColorInt)
    }

    override fun hideUpdateAvailable() {
        versionUpdateCell?.visibility = View.GONE
    }

    override fun showVersionCode(label: String, versionCode: String) {
        versionCodeCell?.visibility = View.VISIBLE
        versionCodeCell?.labelTextView?.text = label
        versionCodeCell?.contentTextView?.text = versionCode
    }

    override fun hideVersionCode() {
        versionCodeCell?.visibility = View.GONE
    }

    override fun showAppStoreID(label: String, id: String) {
        appStoreIDCell?.visibility = View.VISIBLE
        appStoreIDCell?.labelTextView?.text = label
        appStoreIDCell?.contentTextView?.text = id
    }

    override fun hideAppStoreID() {
        appStoreIDCell?.visibility = View.GONE
    }

    override fun showLicense(label: String, licenseName: String) {
        licenseCell?.visibility = View.VISIBLE
        licenseCell?.labelTextView?.text = label
        licenseCell?.contentTextView?.text = licenseName
    }

    override fun hideLicense() {
        licenseCell?.visibility = View.GONE
    }

    override fun showSourceCode(label: String, title: String) {
        sourceCodeCell?.visibility = View.VISIBLE
        sourceCodeCell?.labelTextView?.text = label
        sourceCodeCell?.contentTextView?.text = title
    }

    override fun hideSourceCode() {
        sourceCodeCell?.visibility = View.GONE
    }
}