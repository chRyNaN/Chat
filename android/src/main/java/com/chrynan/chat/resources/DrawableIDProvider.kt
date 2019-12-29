package com.chrynan.chat.resources

import com.chrynan.chat.R
import com.chrynan.chat.di.Inject

class DrawableIDProvider @Inject constructor() : DrawableIDs {

    override val bgAttachmentBadge = R.drawable.bg_attachment_badge

    override val bgLauncher = R.drawable.bg_launcher

    override val icBadgeRemove = R.drawable.ic_badge_remove

    override val icBottomNavbarConversation = R.drawable.ic_bottom_navbar_conversation

    override val icBottomNavbarFeed = R.drawable.ic_bottom_navbar_feed

    override val icBottomNavbarSettings = R.drawable.ic_bottom_navbar_settings

    override val icMessageEditorSend = R.drawable.ic_message_editor_send

    override val icReply = R.drawable.ic_reply

    override val icSent = R.drawable.ic_sent

    override val icToolbarBack = R.drawable.ic_toolbar_back

    override val icUserCircle = R.drawable.ic_user_circle
}