package com.chrynan.chat.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.resources.Colors
import com.chrynan.chat.view.ContactListView
import com.chrynan.chat.viewmodel.ContactItemViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn

class ContactListPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val view: ContactListView,
    private val colors: Colors
) : BasePresenter(dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
    fun getContacts() {
        val contactOne = ContactItemViewModel(
            userID = "",
            userImage = UserImage(
                name = "Chris",
                backgroundColorInt = colors.accentTwo,
                textColorInt = colors.textDark,
                badgeColorInt = null,
                imageUri = null
            ),
            name = "Chris"
        )
        val contactTwo = ContactItemViewModel(
            userID = "",
            userImage = UserImage(
                name = "Mike",
                backgroundColorInt = colors.accentTwo,
                textColorInt = colors.textDark,
                badgeColorInt = null,
                imageUri = null
            ),
            name = "Mike",
            description = "mike@example.com"
        )
        val contactThree = ContactItemViewModel(
            userID = "",
            userImage = UserImage(
                name = "Elizabeth",
                backgroundColorInt = colors.accentTwo,
                textColorInt = colors.textDark,
                badgeColorInt = null,
                imageUri = null
            ),
            name = "Elizabeth"
        )
        val contactFour = ContactItemViewModel(
            userID = "",
            userImage = UserImage(
                name = "Joe",
                backgroundColorInt = colors.accentTwo,
                textColorInt = colors.textDark,
                badgeColorInt = null,
                imageUri = null
            ),
            name = "Joe",
            description = "joe@example.com"
        )
        val contactFive = ContactItemViewModel(
            userID = "",
            userImage = UserImage(
                name = "Chris",
                backgroundColorInt = colors.accentTwo,
                textColorInt = colors.textDark,
                badgeColorInt = null,
                imageUri = null
            ),
            name = "Chris",
            description = "chris@example.com"
        )

        flowOf(listOf(contactOne, contactTwo, contactThree, contactFour, contactFive))
            .calculateAndDispatchDiff()
            .launchIn(this)
    }
}