package com.chrynan.chat.view

interface NotificationView : View {

    fun showNotification(
        message: String,
        type: Type = Type.MESSAGE,
        length: Length = Length.SHORT,
        action: Action? = null
    )

    enum class Type {

        MESSAGE,
        ERROR
    }

    enum class Length {

        SHORT,
        LONG,
        INDEFINITE
    }

    data class Action(
        val title: String,
        val block: () -> Unit
    )
}