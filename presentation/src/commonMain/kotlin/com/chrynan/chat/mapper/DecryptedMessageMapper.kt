package com.chrynan.chat.mapper

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.DecryptedMessage
import com.chrynan.chat.model.ReactionCount
import com.chrynan.chat.viewmodel.*

class DecryptedMessageMapper @Inject constructor() : Mapper<DecryptedMessage, List<MessageListItemViewModel>> {

    override suspend fun map(model: DecryptedMessage): List<MessageListItemViewModel> {
        val viewModels = mutableListOf<MessageListItemViewModel>()

        // TODO only show the date header if it was the first message for the day
        if (model.firstMessageInDate) {
            viewModels.add(
                MessageHeaderDateItemViewModel(
                    messageID = model.id,
                    date = model.dateTime // TODO format the date
                )
            )
        }
        val header = MessageHeaderItemViewModel(
            messageID = model.id,
            name = model.sender.name,
            handle = model.sender.handle,
            image = model.sender.imageUri,
            date = model.dateTime // TODO format the time
        )
        val content = MessageTextItemViewModel(
            messageID = model.id,
            text = model.decryptedContent
        )
        val reaction = MessageReactionItemViewModel(
            messageID = model.id,
            reactions = model.reactions,
            myReactions = model.senderReactions.map { ReactionCount(content = it, count = 1) }
        )
        val thread = MessageThreadItemViewModel(
            messageID = model.id,
            messageCount = "${model.threadedReplyCount}" // TODO properly format this
        )
        val status = MessageStatusItemViewModel(
            messageID = model.id,
            status = "${model.status}", // TODO properly format this
            image = 0 // TODO retrieve the status icon resource ID
        )

        viewModels.addAll(listOf(header, content, reaction, thread, status))

        return viewModels
    }
}