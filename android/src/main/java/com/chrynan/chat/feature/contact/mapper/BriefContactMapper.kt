package com.chrynan.chat.feature.contact.mapper

import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.contact.viewmodel.ContactItemViewModel
import com.chrynan.chat.mapper.Mapper
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.model.contact.BriefContact

class BriefContactMapper @Inject constructor() :
    Mapper<BriefContact, ContactItemViewModel> {

    override suspend fun map(model: BriefContact): ContactItemViewModel {
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