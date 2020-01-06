package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.core.ID
import com.chrynan.chat.model.core.UriString
import com.chrynan.chat.presenter.ContactInfoPresenter
import com.chrynan.chat.ui.adapter.contact.ContactInfoActionAdapter
import com.chrynan.chat.ui.adapter.contact.ContactInfoListItemAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.view.ContactInfoView
import com.chrynan.chat.viewmodel.ContactInfoActionItemViewModel
import com.chrynan.chat.viewmodel.ContactInfoListItemViewModel
import kotlinx.android.synthetic.main.fragment_contact_info.*

class ContactInfoFragment : BaseFragment(),
    ContactInfoView,
    ContactInfoListItemAdapter.ContactInfoListItemSelectedListener,
    ContactInfoActionAdapter.ContactInfoActionSelectedListener {

    companion object {

        private const val KEY_USER_ID = "contactInfoFragmentUserIDKey"

        fun newInstance(userID: ID) = ContactInfoFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_USER_ID, userID)
            }
        }
    }

    @Inject
    override lateinit var presenter: ContactInfoPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    private val userID by lazy { arguments?.getString(KEY_USER_ID)!! }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_contact_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactInfoToolbar?.setNavigationIcon(R.drawable.ic_toolbar_back)
        contactInfoToolbar?.setNavigationOnClickListener { }

        contactInfoRecyclerView?.adapter = adapter
        contactInfoRecyclerView?.layoutManager = layoutManager

        presenter.getInfo(userID)
    }

    override fun onContactInfoListItemSelected(item: ContactInfoListItemViewModel) {

    }

    override fun showHeader(title: String, image: UriString?) {
        contactInfoCollapsingToolbarLayout?.title = title
        contactInfoImageView?.load(image)
    }

    override fun onCallSelected(item: ContactInfoActionItemViewModel) {

    }

    override fun onChatSelected(item: ContactInfoActionItemViewModel) {
    }

    override fun onEmailSelected(item: ContactInfoActionItemViewModel) {
    }

    override fun onQrCodeSelected(item: ContactInfoActionItemViewModel) {
    }
}