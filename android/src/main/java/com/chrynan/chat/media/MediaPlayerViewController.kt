package com.chrynan.chat.media

import com.chrynan.chat.feature.reaction.model.decrypted.DecryptedAttachment

interface MediaPlayerViewController {

    fun bindOrEnter(view: MediaPlayerView, video: DecryptedAttachment.Video)

    fun exit(view: MediaPlayerView)

    fun detach()
}