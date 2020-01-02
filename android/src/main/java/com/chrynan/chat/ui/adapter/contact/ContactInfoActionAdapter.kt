package com.chrynan.chat.ui.adapter.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.di.Inject
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import com.chrynan.chat.viewmodel.ContactInfoActionItemViewModel
import kotlinx.android.synthetic.main.adapter_contact_info_actions.view.*

@Adapter
class ContactInfoActionAdapter @Inject constructor(private val listener: ContactInfoActionSelectedListener) :
    BaseAdapter<ContactInfoActionItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is ContactInfoActionItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_contact_info_actions, parent, false)

    override fun onBindItem(view: View, item: ContactInfoActionItemViewModel) {
        view.apply {
            contactActionCallTextView?.visibility = if (item.defaultPhoneNumber == null) View.GONE else View.VISIBLE
            contactActionChatTextView?.visibility = if (item.defaultHandle == null) View.GONE else View.VISIBLE
            contactActionEmailTextView?.visibility = if (item.defaultEmail == null) View.GONE else View.VISIBLE

            contactActionCallTextView?.setOnClickListener { listener.onCallSelected(item) }
            contactActionChatTextView?.setOnClickListener { listener.onChatSelected(item) }
            contactActionEmailTextView?.setOnClickListener { listener.onEmailSelected(item) }
            contactActionQRCodeTextView?.setOnClickListener { listener.onQrCodeSelected(item) }
        }
    }

    interface ContactInfoActionSelectedListener {

        fun onCallSelected(item: ContactInfoActionItemViewModel)

        fun onChatSelected(item: ContactInfoActionItemViewModel)

        fun onEmailSelected(item: ContactInfoActionItemViewModel)

        fun onQrCodeSelected(item: ContactInfoActionItemViewModel)
    }
}