package com.chrynan.chat.navigation

import com.chrynan.chat.ui.fragment.BaseFragment
import com.chrynan.chat.ui.fragment.ConversationListFragment
import com.chrynan.chat.ui.fragment.FeedFragment
import com.chrynan.chat.ui.fragment.SettingsFragment

class RootTabFragmentFactory : TabFragmentFactory<RootTab> {

    override val defaultTab = RootTab.CONVERSATIONS

    override val rootTabs = listOf(RootTab.FEED, RootTab.CONVERSATIONS, RootTab.SETTINGS)

    override fun create(tab: RootTab): BaseFragment = when (tab) {
        RootTab.FEED -> FeedFragment.newInstance()
        RootTab.CONVERSATIONS -> ConversationListFragment.newInstance()
        RootTab.SETTINGS -> SettingsFragment.newInstance()
    }
}