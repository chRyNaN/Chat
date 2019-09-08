package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chrynan.chat.R
import com.chrynan.chat.binder.AppInfoBinder
import com.chrynan.chat.coroutines.AndroidCoroutineDispatchers
import com.chrynan.chat.presenter.AppInfoPresenter
import com.chrynan.chat.view.AppInfoView

class AppInfoFragment : BaseFragment(),
    AppInfoView {

    companion object {

        fun newInstance() = AppInfoFragment()
    }

    private val versionTitleTextView by lazy { view!!.findViewById<TextView>(R.id.versionTitleTextView) }
    private val versionDescriptionTextView by lazy { view!!.findViewById<TextView>(R.id.versionDescriptionTextView) }
    private val updateDescriptionTextView by lazy { view!!.findViewById<TextView>(R.id.versionUpdateTitleTextView) }

    override val presenter: AppInfoPresenter by lazy {
        AppInfoPresenter(
            dispatchers = AndroidCoroutineDispatchers(),
            binder = AppInfoBinder(view = this)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_app_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getInfo()
    }

    override fun showVersion(version: String) {
        versionTitleTextView.visibility = View.VISIBLE
        versionDescriptionTextView.visibility = View.VISIBLE
        versionDescriptionTextView.text = version
    }

    override fun hideVersion() {
        versionTitleTextView.visibility = View.GONE
        versionTitleTextView.visibility = View.GONE
    }

    override fun showUpdateDescription(updateDescription: String) {
        updateDescriptionTextView.visibility = View.VISIBLE
        updateDescriptionTextView.text = updateDescription
    }

    override fun hideUpdateDescription() {
        updateDescriptionTextView.visibility = View.GONE
    }
}