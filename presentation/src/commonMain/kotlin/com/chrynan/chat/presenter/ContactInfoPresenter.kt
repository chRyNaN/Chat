package com.chrynan.chat.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.ID
import com.chrynan.chat.view.ContactInfoView
import com.chrynan.chat.viewmodel.ContactInfoActionItemViewModel
import com.chrynan.chat.viewmodel.ContactInfoListItemViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn

class ContactInfoPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ContactInfoView
) : BasePresenter(dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
    fun getInfo(userID: ID) {
        view.showHeader(
            title = "Chris Keenan",
            image = "https://www.gravatar.com/avatar/2179fa575001969b7a3397951ef91a8f?s=250&d=mm&r=x"
        )

        val actions = ContactInfoActionItemViewModel(
            userID = "",
            defaultEmail = "chris@chrynan.codes",
            defaultHandle = "chris@chrynan.codes",
            defaultPhoneNumber = "5555555555"
        )

        val email = ContactInfoListItemViewModel(
            userID = "",
            label = "Email",
            title = "chris@chrynan.com"
        )

        val phoneNumber = ContactInfoListItemViewModel(
            userID = "",
            label = "Phone",
            title = "5555555555"
        )

        flowOf(listOf(actions, email, phoneNumber))
            .calculateAndDispatchDiff()
            .launchIn(this)
    }
}