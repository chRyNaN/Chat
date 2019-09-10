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

    private val backStack = FragmentBackStack<T, BaseFragment>()

    fun addFragmentToCurrentTab(
        fragment: BaseFragment,
        containerId: Int = R.id.fragmentContainer,
        addToBackStack: Boolean = false
    ) {
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(containerId, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null).commit()
            fragmentManager.executePendingTransactions()
        } else {
            transaction.commitNow()
        }

        backStack.pushFragmentForTab(fragment, currentTab)
    }

    fun removeFragmentFromCurrentTab() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
            backStack.popFragmentForTab(currentTab)
        }
    }

    fun clearCurrentStack() {
        // TODO
    }

    fun switchTab(tab: T) {
        currentTab = tab
        // TODO
    }
}