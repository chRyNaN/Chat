package com.chrynan.chat.feature.settings.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.settings.viewmodel.ProjectDependencyItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_project_dependency.view.*
import javax.inject.Inject

@Adapter
class ProjectDependencyAdapter @Inject constructor(private val listener: ProjectDependencySelectedListener) :
    BaseAdapter<ProjectDependencyItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ProjectDependencyItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_project_dependency,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ProjectDependencyItemViewModel) {
        view.apply {
            projectDependencyTitleTextView?.text = item.name
            projectDependencyVersionTextView?.text = item.version
            projectDependencyDescriptionTextView?.text = item.description
            projectDependencyDescriptionTextView?.visibility =
                if (item.description == null) View.GONE else View.VISIBLE
            setOnClickListener { listener.onProjectDependencySelected(item) }
        }
    }

    interface ProjectDependencySelectedListener {

        fun onProjectDependencySelected(item: ProjectDependencyItemViewModel)
    }
}