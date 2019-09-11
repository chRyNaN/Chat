package com.chrynan.chat.navigation.root

import com.chrynan.chat.R
import com.chrynan.chat.navigation.core.Tab

enum class RootTab(override val id: Int) : Tab {

    FEED(R.id.menu_bottom_feed),
    CONVERSATIONS(R.id.menu_bottom_conversations),
    SETTINGS(R.id.menu_bottom_settings)
}