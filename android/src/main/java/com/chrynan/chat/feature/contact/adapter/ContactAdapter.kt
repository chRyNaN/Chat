package com.chrynan.chat.feature.contact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.contact.viewmodel.ContactItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_contact.view.*
import javax.inject.Inject

@Adapter
class ContactAdapter @Inject constructor(private val listener: ContactSelectedListener) :
    BaseAdapter<ContactItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ContactItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_contact, parent, false)

    override fun onBindItem(view: View, item: ContactItemViewModel) {
        view.apply {
            contactUserImageView?.userImage = item.userImage
            contactTitleTextView?.text = item.name
            contactDescriptionTextView?.text = item.description
            contactDescriptionTextView?.visibility =
                if (item.description == null) View.GONE else View.VISIBLE
            setOnClickListener { listener.onContactSelected(item) }
        }
    }

    interface ContactSelectedListener {

        fun onContactSelected(item: ContactItemViewModel)
    }
}