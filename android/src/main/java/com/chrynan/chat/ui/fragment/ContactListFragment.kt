package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.presenter.ContactListPresenter
import com.chrynan.chat.view.ContactListView

class ContactListFragment : BaseFragment(),
    ContactListView {

    companion object {

        fun newInstance() = ContactListFragment()
    }

    @Inject
    override lateinit var presenter: ContactListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}