package com.chrynan.chat.mapper

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.DecryptedAttachment
import com.chrynan.chat.model.DecryptedMessage
import com.chrynan.chat.resources.DrawableIDs
import com.chrynan.chat.resources.Strings
import com.chrynan.chat.viewmodel.*

class DecryptedMessageMapper @Inject constructor(
    private val strings: Strings,
    private val drawableIDs: DrawableIDs
) : Mapper<DecryptedMessage, List<AdapterItem>> {

    override suspend fun map(model: DecryptedMessage): List<AdapterItem> {
        val viewModels = mutableListOf<AdapterItem>()

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
            isOnline = true,
            date = model.dateTime // TODO format the time
        )
        val content = MessageTextItemViewModel(
            messageID = model.id,
            text = model.decryptedContent
        )
        val thread = MessageActionItemViewModel(
            messageID = model.id,
            messageCount = "${model.threadedReplyCount} Replies", // TODO properly format this
            lastReplyDate = "Yesterday",
            replyUserImageUris = listOf(
                "https://randomuser.me/api/portraits/lego/1.jpg"
            ),
            statusImageResourceID = 0,
            status = "Sent"
        )
        val link = MessageLinkPreviewItemViewModel(
            messageID = model.id,
            link = "chrynan.codes",
            title = "Software Engineering Blog",
            description = "Description Text",
            imageUri = "https://www.gravatar.com/avatar/2179fa575001969b7a3397951ef91a8f?s=250&d=mm&r=x"
        )
        val image = MessageVideoItemViewModel(
            messageID = model.id,
            video = DecryptedAttachment.Video(
                decryptedName = "",
                uri = "https://www.w3schools.com/html/mov_bbb.mp4",
                thumbnail = "https://cdn.wccftech.com/wp-content/uploads/2016/09/spacee-2060x1288.jpg"
            )
        )
        val typing = MessageTypingItemViewModel(text = "Chris is typing...")

        viewModels.addAll(listOf(header, content, link, image, thread, typing))

        return viewModels
    }
}