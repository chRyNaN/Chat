package com.chrynan.chat.interactor

import com.chrynan.chat.di.Inject
import com.chrynan.chat.model.decrypted.DecryptedMessage
import com.chrynan.chat.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetDecryptedMessagesInteractor @Inject constructor() {

    operator fun invoke(): Flow<List<DecryptedMessage>> {
        val messageOne = DecryptedMessage(
            id = "1",
            dateTime = "11:00",
            firstMessageInDate = true,
            sender = User(
                userID = "userOne",
                accountID = "accountOne",
                name = "Chris",
                handle = "chris@chrynan.com",
                imageUri = null
            ),
            decryptedContent = "This is an example of a decrypted message. This message will be displayed"
        )
        val messageTwo = DecryptedMessage(
            id = "2",
            dateTime = "11:15",
            sender = User(
                userID = "userOne",
                accountID = "accountOne",
                name = "Chris",
                handle = "chris@chrynan.com",
                imageUri = null
            ),
            decryptedContent = "This is another message, sent by the same user."
        )
        val messageThree = DecryptedMessage(
            id = "3",
            dateTime = "12:22",
            sender = User(
                userID = "userTwo",
                accountID = "accountTwo",
                name = "Other User",
                handle = "other@chrynan.com",
                imageUri = null
            ),
            decryptedContent = "Hey, Okay"
        )

        return flowOf(listOf(messageOne, messageTwo, messageThree))
    }
}