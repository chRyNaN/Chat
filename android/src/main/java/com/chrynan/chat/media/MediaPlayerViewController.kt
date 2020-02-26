package com.chrynan.chat.media

import com.chrynan.chat.model.decrypted.DecryptedAttachment

interface MediaPlayerViewController {

    fun bindOrEnter(view: MediaPlayerView, video: DecryptedAttachment.Video)

    fun exit(view: MediaPlayerView)

    fun detach()
}