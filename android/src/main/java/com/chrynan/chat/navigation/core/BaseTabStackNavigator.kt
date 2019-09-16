package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.chrynan.chat.collections.*

open class BaseTabStackNavigator<T : Tab, B : Fragment> internal constructor(
    private val factory: TabStackFactory<T, B>,
    private val handler: FragmentTransactionHandler
) : ViewModel(),
    TabStackNavigator<T, B> {

    override var currentTab: T = factory.defaultTab
        protected set

    override lateinit var activity: FragmentActivity
        internal set

    override var listeners = mutableListOf<TabStackListener<T>>()

    private val backStack = MultipleStack<T, FragmentInfo>()
    private val actionStack = mutableStackOf<TabStackAction<T>>()

    override fun switchTab(tab: T) {
        if (tab == currentTab) {
            refreshCurrentTab()
        } else {
            switchToNewTab(tab = tab)
        }
    }

    override fun goToFragment(fragment: B) {
        val info = handler.addFragment(fragment)

        val currentStack = backStack.get(currentTab)
        val newStack = currentStack + info

        backStack.push(MultipleStackResult(key = currentTab, value = newStack))
        actionStack.push(FragmentPushAction(on = currentTab, info = info))
    }

    override fun goBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun refreshCurrentTab() {
        val fragment =
            if (backStack.containsKey(currentTab) && backStack.get(currentTab).isNotEmpty()) {
                val stack = backStack.get(currentTab)

                handler.removeFragmentsExceptForBottomOfStack(stack = stack)
            } else {
                createAndAddRootFragmentForTab(tab = currentTab)
            }

        listeners.onRefreshTab(tab = currentTab, fragment = fragment)
    }

    private fun switchToNewTab(tab: T) {
        if (backStack.containsKey(tab)) {
            // The root fragment is already created
            val stack = backStack.get(tab)
            val info = stack.peek()
            handler.showExistingFragment(info)
        } else {
            // The root fragment has to be created
            createAndAddRootFragmentForTab(tab = tab)
        }

        actionStack.push(SwitchTabAction(from = currentTab, to = currentTab))

        listeners.onTabSwitched(from = currentTab, to = tab)

        currentTab = tab
    }

    private fun createAndAddRootFragmentForTab(tab: T): Fragment {
        val rootFragment = factory.createRootFragment(tab)
        val info = handler.addFragment(rootFragment)
        val stack = stackOf(info)

        backStack.push(MultipleStackResult(key = tab, value = stack))

        return rootFragment
    }
}