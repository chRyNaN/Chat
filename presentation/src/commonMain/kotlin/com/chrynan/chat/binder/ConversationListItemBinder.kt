package com.chrynan.chat.binder

import com.chrynan.chat.view.ConversationListItemView
import com.chrynan.chat.viewmodel.ConversationListItemViewModel

class ConversationListItemBinder : Binder<ConversationListItemView, ConversationListItemViewModel> {

    override lateinit var view: ConversationListItemView

    override suspend fun bind(viewModel: ConversationListItemViewModel) {
        view.apply {
            title = viewModel.title
            description = viewModel.description
            userImage = viewModel.userImage
            formattedDateTime = viewModel.formattedDateTime
        }
    }
}