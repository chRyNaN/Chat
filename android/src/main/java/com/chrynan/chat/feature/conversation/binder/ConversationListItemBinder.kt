package com.chrynan.chat.feature.conversation.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.feature.conversation.view.ConversationListItemView
import com.chrynan.chat.feature.conversation.viewmodel.ConversationListItemViewModel
import javax.inject.Inject

class ConversationListItemBinder @Inject constructor() :
    Binder<ConversationListItemView, ConversationListItemViewModel> {

    override lateinit var view: ConversationListItemView

    override suspend fun bind(viewModel: ConversationListItemViewModel) {
        view.apply {
            title = viewModel.title
            description = viewModel.description
            userImage = viewModel.userImage
            formattedDateTime = viewModel.formattedDateTime
            showNewItemBadge = viewModel.showNewItemBadge
        }
    }
}