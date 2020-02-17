package com.chrynan.chat.feature.conversation.mapper

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.di.Inject
import com.chrynan.chat.feature.conversation.viewmodel.*
import com.chrynan.chat.mapper.Mapper
import com.chrynan.chat.model.UserImage
import com.chrynan.chat.model.decrypted.DecryptedAttachment
import com.chrynan.chat.model.decrypted.DecryptedMessage
import com.chrynan.chat.resources.Colors
import com.chrynan.chat.resources.DrawableIDs
import com.chrynan.chat.resources.Strings
import com.chrynan.chat.utils.UserColorProvider

class DecryptedMessageMapper @Inject constructor(
    private val strings: Strings,
    private val drawableIDs: DrawableIDs,
    private val colors: Colors,
    private val userColorProvider: UserColorProvider
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
            date = model.dateTime, // TODO format the time
            userImage = UserImage(
                name = model.sender.name,
                backgroundColorInt = userColorProvider.getColorFor(model.sender.name),
                textColorInt = colors.textDark,
                badgeColorInt = colors.online,
                imageUri = model.sender.imageUri
            )
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
        val video = MessageVideoItemViewModel(
            messageID = model.id,
            video = DecryptedAttachment.Video(
                decryptedName = "",
                uri = "https://www.w3schools.com/html/mov_bbb.mp4",
                thumbnail = "https://cdn.wccftech.com/wp-content/uploads/2016/09/spacee-2060x1288.jpg"
            )
        )
        val image = MessageImageItemViewModel(
            messageID = model.id,
            image = DecryptedAttachment.Image(
                decryptedName = "",
                uri = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fqicez529ing%2Fmaxresdefault.jpg&f=1&nofb=1"
            )
        )
        val file = MessageFileItemViewModel(
            messageID = model.id,
            file = DecryptedAttachment.File(
                decryptedName = "Test File Name",
                uri = "Test Uri"
            )
        )
        val typing = MessageTypingItemViewModel(text = "Chris is typing...")

        viewModels.addAll(listOf(header, content, link, video, image, file, thread, typing))

        return viewModels
    }
}