package com.chrynan.chat.view

import com.chrynan.chat.model.UserImage

interface ConversationListItemView : View {

    var title: String
    var description: String
    var userImage: UserImage?
    var formattedDateTime: String
}