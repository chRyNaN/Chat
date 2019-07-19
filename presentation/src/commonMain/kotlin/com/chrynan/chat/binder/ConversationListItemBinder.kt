package com.chrynan.chat.binder

import com.chrynan.chat.view.ConversationListItemView
import com.chrynan.chat.viewmodel.ConversationListItemViewModel

class ConversationListItemBinder : Binder<ConversationListItemViewModel> {

    lateinit var view: ConversationListItemView

    override suspend fun bind(viewModel: ConversationListItemViewModel) {
        view.apply {
            title = viewModel.title
            description = viewModel.description
            imageUri = viewModel.imageUri
            formattedDateTime = viewModel.formattedDateTime
        }
    }
}