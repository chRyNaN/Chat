package com.chrynan.chat.view

interface ConversationListItemView : View {

    var title: String
    var description: String
    var imageUri: String?
    var formattedDateTime: String
}