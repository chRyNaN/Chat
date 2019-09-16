package com.chrynan.chat.navigation.core

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.chrynan.chat.collections.*

open class BaseTabStackNavigator<T : Tab, B : Fragment> internal constructor(private val factory: TabStackFactory<T, B>) :
    TabStackNavigator<T, B> {

    override var currentTab: T = factory.defaultTab
        protected set

    override lateinit var activity: FragmentActivity
        internal set

    override var listeners = mutableListOf<TabStackListener<T>>()

    lateinit var handler: FragmentTransactionHandler
        internal set

    private val backStack = MultipleStack<T, FragmentInfo>()
    private val actionStack = mutableDequeOf<TabStackAction<T>>()

    override fun switchTab(tab: T) {
        if (tab == currentTab) {
            refreshCurrentTab()
        } else {
            switchToNewTab(tab = tab)
        }
    }

    override fun goToFragment(fragment: B) {
        val info = handler.addFragment(fragment)

        val stack = backStack.get(currentTab)
        stack.push(info)

        backStack.push(MultipleStackResult(key = currentTab, value = stack))
        actionStack.pushLast(FragmentPushAction(on = currentTab, info = info))
    }

    override fun goBack(): Boolean {
        when (val lastAction = actionStack.getLastOrNull() ?: return false) {
            is DefaultTabAction -> {
                // We are on the default root fragment, so return false because we can't go back further
                return false
            }
            is SwitchTabAction -> {
                // Remove the current back stack of fragments, then add the previous tabs back stack
                val fragmentsToRemove = backStack.get(lastAction.to)
                val fragmentsToShow = backStack.get(lastAction.from)

                handler.removeFragmentsThenAddFragments(
                    fragmentsToRemove = fragmentsToRemove,
                    fragmentsToShow = fragmentsToShow
                )

                return true
            }
            is FragmentPushAction -> {
                // Remove the previously added fragment
                handler.popFragmentBackStack()

                val stack = backStack.get(lastAction.on).toMutableStack()
                stack.pop()

                backStack.push(MultipleStackResult(key = lastAction.on, value = stack))

                return true
            }
        }
    }

    override fun showDialog(fragment: DialogFragment) {
        // TODO
    }

    override fun reset() {
        handler.clear()
        backStack.clear()
        actionStack.clear()
        setupDefault()
    }

    internal fun setupDefault() {
        createAndAddRootFragmentForTab(tab = currentTab)
        actionStack.pushLast(DefaultTabAction(tab = currentTab))
    }

    private fun refreshCurrentTab() {
        val fragment =
            if (backStack.containsKey(currentTab) && backStack.get(currentTab).isNotEmpty()) {
                val stack = backStack.get(currentTab)

                stack.removeAllExceptForLast()

                backStack.push(MultipleStackResult(key = currentTab, value = stack))

                handler.removeFragmentsExceptForBottomOfStack(stack = stack)
            } else {
                createAndAddRootFragmentForTab(tab = currentTab)
            }

        listeners.onRefreshTab(tab = currentTab, fragment = fragment)
    }

    private fun switchToNewTab(tab: T) {
        if (backStack.containsKey(tab) && backStack.get(tab).isNotEmpty()) {
            val fragmentsToRemove = backStack.get(currentTab)
            val fragmentsToShow = backStack.get(tab)

            handler.removeFragmentsThenAddFragments(
                fragmentsToRemove = fragmentsToRemove,
                fragmentsToShow = fragmentsToShow
            )
        } else {
            val rootFragment = factory.createRootFragment(tab)
            val info = handler.removeFragmentsThenAddFragments(
                fragmentsToRemove = backStack.get(currentTab),
                fragmentsToShow = emptyList(),
                topFragment = rootFragment
            )
            val stack = mutableStackOf(info)

            backStack.push(MultipleStackResult(key = tab, value = stack))
        }

        actionStack.pushLast(SwitchTabAction(from = currentTab, to = currentTab))

        listeners.onTabSwitched(from = currentTab, to = tab)

        currentTab = tab
    }

    private fun createAndAddRootFragmentForTab(tab: T): Fragment {
        val rootFragment = factory.createRootFragment(tab)
        val info = handler.addFragment(rootFragment)
        val stack = mutableStackOf(info)

        backStack.push(MultipleStackResult(key = tab, value = stack))

        return rootFragment
    }
}