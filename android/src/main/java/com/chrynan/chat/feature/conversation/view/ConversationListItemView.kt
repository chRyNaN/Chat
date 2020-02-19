package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.feature.reaction.model.UserImage
import com.chrynan.chat.view.View

interface ConversationListItemView : View {

    var title: String
    var description: String
    var userImage: UserImage?
    var formattedDateTime: String
    var showNewItemBadge: Boolean
}