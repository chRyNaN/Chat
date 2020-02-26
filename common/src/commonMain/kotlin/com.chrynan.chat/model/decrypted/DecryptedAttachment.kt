package com.chrynan.chat.model.decrypted

import com.chrynan.chat.model.core.UriString

sealed class DecryptedAttachment {

    abstract val decryptedName: String
    abstract val uri: UriString

    data class Video(
        override val decryptedName: String,
        override val uri: UriString,
        val thumbnail: UriString
    ) : DecryptedAttachment()

    data class Audio(
        override val decryptedName: String,
        override val uri: UriString
    ) : DecryptedAttachment()

    data class Image(
        override val decryptedName: String,
        override val uri: UriString
    ) : DecryptedAttachment()

    data class File(
        override val decryptedName: String,
        override val uri: UriString
    ) : DecryptedAttachment()
}

