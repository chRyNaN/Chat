package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.contact.presenter.ContactListPresenter
import com.chrynan.chat.feature.contact.activity.ContactInfoActivity
import com.chrynan.chat.feature.contact.adapter.ContactAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.feature.contact.view.ContactListView
import com.chrynan.chat.feature.contact.viewmodel.ContactItemViewModel
import kotlinx.android.synthetic.main.fragment_contact_list.*

class ContactListFragment : BaseFragment(),
    ContactListView,
    ContactAdapter.ContactSelectedListener {

    companion object {

        fun newInstance() = ContactListFragment()
    }

    @Inject
    override lateinit var presenter: ContactListPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactRecyclerView?.adapter = adapter
        contactRecyclerView?.layoutManager = layoutManager

        presenter.getContacts()
    }

    override fun onContactSelected(item: ContactItemViewModel) {
        startActivity(ContactInfoActivity.newIntent(context!!, item.userID))
    }
}