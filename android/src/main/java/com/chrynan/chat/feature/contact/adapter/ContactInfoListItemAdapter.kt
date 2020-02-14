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
import com.chrynan.chat.feature.contact.viewmodel.ContactInfoListItemViewModel
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_contact_info_list_item.view.*
import javax.inject.Inject

@Adapter
class ContactInfoListItemAdapter @Inject constructor(private val listener: ContactInfoListItemSelectedListener) :
    BaseAdapter<ContactInfoListItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ContactInfoListItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_contact_info_list_item,
            parent,
            false
        )

    override fun onBindItem(view: View, item: ContactInfoListItemViewModel) {
        view.apply {
            contactListItemLabelTextView?.text = item.label
            contactListItemTitleTextView?.text = item.title
            contactListItemDescriptionTextView?.text = item.description
            contactListItemDescriptionTextView?.visibility =
                if (item.description == null) View.GONE else View.VISIBLE
            contactListItemIconImageView?.visibility =
                if (item.iconResourceID == null) View.GONE else View.VISIBLE
            contactListItemImageView?.visibility =
                if (item.imageUri == null) View.GONE else View.VISIBLE
            item.iconResourceID?.let { contactListItemIconImageView?.setImageResource(it) }
            contactListItemImageView?.load(item.imageUri)
            setOnClickListener { listener.onContactInfoListItemSelected(item) }
        }
    }

    interface ContactInfoListItemSelectedListener {

        fun onContactInfoListItemSelected(item: ContactInfoListItemViewModel)
    }
}