package com.chrynan.chat.feature.contact.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.chrynan.chat.feature.contact.view.EditContactView
import com.chrynan.chat.ui.fragment.BaseFragment

class EditContactFragment : BaseFragment(),
    EditContactView {

    companion object {

        fun newInstance() =
            EditContactFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_edit_contact, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}