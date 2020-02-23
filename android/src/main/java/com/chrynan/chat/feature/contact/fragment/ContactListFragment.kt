package com.chrynan.chat.feature.contact.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.contact.activity.ContactInfoActivity
import com.chrynan.chat.feature.contact.adapter.ContactAdapter
import com.chrynan.chat.feature.contact.presenter.ContactListPresenter
import com.chrynan.chat.feature.contact.view.ContactListView
import com.chrynan.chat.feature.contact.viewmodel.ContactItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_contact_list.*
import kotlinx.android.synthetic.main.layout_collapsing_app_bar.*
import javax.inject.Inject

class ContactListFragment : BaseFragment(),
    ContactListView,
    ContactAdapter.ContactSelectedListener {

    companion object {

        fun newInstance() =
            ContactListFragment()
    }

    private val titleText by lazy { getString(R.string.app_bar_title_contacts) }

    @Inject
    override lateinit var presenter: ContactListPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout?.title = titleText

        contactListRecyclerView?.adapter = adapter
        contactListRecyclerView?.layoutManager = layoutManager
        contactListSwipeRefreshLayout?.setOnRefreshListener {
            presenter.loadMore()
        }
        contactListNewFab?.setOnClickListener { }

        presenter.getContacts()
    }

    override fun toggleLoading(isLoading: Boolean) {
        contactListSwipeRefreshLayout?.isRefreshing = isLoading
    }

    override fun onContactSelected(item: ContactItemViewModel) {
        startActivity(ContactInfoActivity.newIntent(context!!, item.userID))
    }
}