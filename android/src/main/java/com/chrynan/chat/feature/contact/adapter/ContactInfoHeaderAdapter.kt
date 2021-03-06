package com.chrynan.chat.feature.contact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.contact.viewmodel.ContactInfoHeaderItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_contact_info_header.view.*
import javax.inject.Inject

@Adapter
class ContactInfoHeaderAdapter @Inject constructor() :
    BaseAdapter<ContactInfoHeaderItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ContactInfoHeaderItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_contact_info_header,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ContactInfoHeaderItemViewModel) {
        view.apply {
            item.imageUriString?.let { contactHeaderImageView?.load(it) }
            contactHeaderNameTextView?.text = item.fullName
        }
    }
}