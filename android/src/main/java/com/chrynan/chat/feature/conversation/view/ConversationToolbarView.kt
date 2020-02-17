package com.chrynan.chat.feature.conversation.view

import com.chrynan.chat.model.UserImage
import com.chrynan.chat.view.View

interface ConversationToolbarView : View {

    fun showUserImage(userImage: UserImage)

    fun hideUserImage()

    fun showTitle(title: String)

    fun hideTitle()
}