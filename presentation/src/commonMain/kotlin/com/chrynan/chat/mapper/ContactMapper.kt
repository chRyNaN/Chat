package com.chrynan.chat.mapper

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.model.contact.Contact
import com.chrynan.chat.viewmodel.ContactItemViewModel

class ContactMapper @Inject constructor() : Mapper<Contact, ContactItemViewModel> {

    override suspend fun map(model: Contact): ContactItemViewModel {
        val contactName = model.name.nickname ?: model.name.firstName

        return ContactItemViewModel(
            userID = model.id,
            name = contactName,
            userImage = UserImage(
                name = contactName,
                badgeColorInt = 0,
                backgroundColorInt = 0,
                textColorInt = 0,
                imageUri = model.imageUri
            ),
            description = null
        )
    }
}