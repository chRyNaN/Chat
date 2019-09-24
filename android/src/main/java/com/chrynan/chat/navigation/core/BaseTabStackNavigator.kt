package com.chrynan.chat.navigation.core

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class BaseTabStackNavigator<T : Tab, B : Fragment> internal constructor(private val factory: TabStackFactory<T, B>) :
    TabStackNavigator<T, B> {

    override var currentTab: T = factory.defaultTab
        protected set

    override lateinit var activity: FragmentActivity
        internal set

    override var listeners = mutableListOf<TabStackListener<T, B>>()

    lateinit var handler: FragmentTransactionHandler
        internal set

    private val backStack = mutableMapOf<T, MutableList<B>>()
    private val actionStack = mutableListOf<TabStackAction<T>>()

    override fun selectTab(tab: T) {
        if (tab == currentTab) {
            refreshCurrentTab()
        } else {
            switchToNewTab(tab = tab)
        }
    }

    override fun goToFragment(fragment: B) {
        val stack = backStack[currentTab]?.apply {
            push(fragment)
        }

        if (stack != null) {
            handler.addFragmentToStack(fragment)

            backStack[currentTab] = stack
            actionStack.push(FragmentPushAction(on = currentTab, fragment = fragment))
        }
    }

    override fun goBack(): Boolean {
        when (val lastAction = actionStack.popOrNull() ?: return false) {
            is DefaultTabAction -> {
                // We are on the default root fragment, so return false because we can't go back further
                return false
            }
            is SwitchTabAction -> {
                // Remove the current back stack of fragments, then add the previous tabs back stack
                val fragmentsToShow = backStack[lastAction.from] ?: return false

                handler.showFragmentStack(fragmentsToShow)

                return true
            }
            is FragmentPushAction -> {
                // Remove the previously added fragment
                handler.popFragmentStack()

                val stack = backStack[lastAction.on]?.apply {
                    popOrNull()
                } ?: return false

                backStack[lastAction.on] = stack

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

        actionStack.push(DefaultTabAction(tab = currentTab))
    }

    private fun refreshCurrentTab() {
        val fragment =
            if (backStack.containsKey(currentTab) && backStack[currentTab]!!.isNotEmpty()) {
                val stack = backStack[currentTab]!!

                val root = stack.first()

                backStack[currentTab] = mutableListOf(root)

                handler.showFragmentStack(listOf(root))

                root
            } else {
                createAndAddRootFragmentForTab(tab = currentTab)
            }

        listeners.onRefreshTab(tab = currentTab, fragment = fragment)
    }

    private fun switchToNewTab(tab: T) {
        if (backStack.containsKey(tab) && backStack[tab]!!.isNotEmpty()) {

            val stack = backStack[tab]!!

            handler.showFragmentStack(stack)
        } else {
            createAndAddRootFragmentForTab(tab = tab)
        }

        actionStack.push(SwitchTabAction(from = currentTab, to = tab))

        listeners.onTabSwitched(from = currentTab, to = tab)

        currentTab = tab
    }

    private fun createAndAddRootFragmentForTab(tab: T): B {
        val rootFragment = factory.createRootFragment(tab)

        val stack = mutableListOf(rootFragment)

        handler.showFragmentStack(stack)

        backStack[tab] = stack

        return rootFragment
    }
}