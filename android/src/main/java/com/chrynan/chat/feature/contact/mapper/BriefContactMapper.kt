package com.chrynan.chat.feature.contact.mapper

import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.contact.viewmodel.ContactItemViewModel
import com.chrynan.chat.mapper.Mapper
import com.chrynan.chat.feature.reaction.model.UserImage
import com.chrynan.chat.feature.reaction.model.contact.BriefContact
import com.chrynan.chat.resources.Colors
import com.chrynan.chat.utils.UserColorProvider

class BriefContactMapper @Inject constructor(
    private val userColorProvider: UserColorProvider,
    private val colors: Colors
) :
    Mapper<BriefContact, ContactItemViewModel> {

    override suspend fun map(model: BriefContact): ContactItemViewModel {
        val contactName = model.name.nickname ?: model.name.firstName

        return ContactItemViewModel(
            userID = model.id,
            name = contactName,
            userImage = UserImage(
                name = contactName,
                badgeColorInt = colors.online,
                backgroundColorInt = userColorProvider.getColorFor(contactName),
                textColorInt = colors.textDark,
                imageUri = model.imageUri
            ),
            description = null
        )
    }
}