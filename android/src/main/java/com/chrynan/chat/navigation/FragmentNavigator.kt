package com.chrynan.chat.navigation

import androidx.fragment.app.FragmentManager
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.BaseFragment

class FragmentNavigator<T : Tab>(
    private val factory: TabFragmentFactory<T>,
    private val fragmentManager: FragmentManager
) {

    var currentTab: T = factory.defaultTab
        private set

    private val backStack = BackStack<T>()

    fun addFragmentToCurrentTab(fragment: BaseFragment, containerId: Int = R.id.fragmentContainer) {
        // TODO
    }

    fun removeFragmentFromCurrentTab() {
        // TODO
    }

    fun switchTab(tab: T) {
        // TODO
    }
}