package com.chrynan.chat.navigation

import com.chrynan.chat.R

enum class RootTab(override val id: Int) : Tab {

    FEED(R.id.menu_bottom_feed),
    CONVERSATIONS(R.id.menu_bottom_conversations),
    SETTINGS(R.id.menu_bottom_settings)
}