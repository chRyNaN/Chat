package com.chrynan.chat.feature.settings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.settings.presenter.OpenSourceLicensesPresenter
import com.chrynan.chat.ui.activity.BaseActivity
import com.chrynan.chat.feature.settings.adapter.ProjectDependencyAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.feature.settings.view.OpenSourceLicensesView
import com.chrynan.chat.feature.settings.viewmodel.ProjectDependencyItemViewModel
import kotlinx.android.synthetic.main.fragment_open_source_licenses.*
import kotlinx.android.synthetic.main.layout_collapsing_app_bar.*
import javax.inject.Inject

class OpenSourceLicensesFragment : BaseFragment(),
    OpenSourceLicensesView,
    ProjectDependencyAdapter.ProjectDependencySelectedListener {

    companion object {

        fun newInstance() =
            OpenSourceLicensesFragment()
    }

    @Inject
    override lateinit var presenter: OpenSourceLicensesPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    private val title by lazy { getString(R.string.open_source_licenses_title) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_open_source_licenses, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout?.title = title
        toolbar?.setNavigationIcon(R.drawable.ic_toolbar_back)
        toolbar?.setNavigationOnClickListener { (activity as? BaseActivity)?.goBack() }

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        presenter.getLicenses()
    }

    override fun onProjectDependencySelected(item: ProjectDependencyItemViewModel) {

    }
}