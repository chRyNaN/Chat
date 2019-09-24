package com.chrynan.chat.navigation.core

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.chrynan.chat.collections.MultipleStack
import com.chrynan.chat.collections.MultipleStackResult
import com.chrynan.chat.collections.clear
import com.chrynan.chat.collections.mutableStackOf

open class BaseTabStackNavigator<T : Tab, B : Fragment> internal constructor(private val factory: TabStackFactory<T, B>) :
    TabStackNavigator<T, B> {

    override var currentTab: T = factory.defaultTab
        protected set

    override lateinit var activity: FragmentActivity
        internal set

    override var listeners = mutableListOf<TabStackListener<T, B>>()

    lateinit var handler: FragmentTransactionHandler
        internal set

    private val backStack = MultipleStack<T, B>()
    private val actionStack = mutableListOf<TabStackAction<T>>()

    override fun selectTab(tab: T) {
        if (tab == currentTab) {
            refreshCurrentTab()
        } else {
            switchToNewTab(tab = tab)
        }
    }

    override fun goToFragment(fragment: B) {
        Log.w("STACK", "Navigator: goToFragment: fragment = $fragment")

        handler.addFragmentToStack(fragment)

        val stack = backStack.get(currentTab).apply {
            push(fragment)
        }

        backStack.push(MultipleStackResult(key = currentTab, value = stack))
        actionStack.push(FragmentPushAction(on = currentTab, fragment = fragment))
    }

    override fun goBack(): Boolean {
        Log.w("STACK", "Navigator: goBack")

        when (val lastAction = actionStack.popOrNull() ?: return false) {
            is DefaultTabAction -> {
                Log.w("STACK", "Navigator: goBack: DefaultTabAction: action = $lastAction")

                // We are on the default root fragment, so return false because we can't go back further
                return false
            }
            is SwitchTabAction -> {
                Log.w("STACK", "Navigator: goBack: SwitchTabAction: action = $lastAction")

                // Remove the current back stack of fragments, then add the previous tabs back stack
                val fragmentsToShow = backStack.get(lastAction.from)

                handler.showFragmentStack(fragmentsToShow)

                return true
            }
            is FragmentPushAction -> {
                Log.w("STACK", "Navigator: goBack: FragmentPushAction: action = $lastAction")

                // Remove the previously added fragment
                handler.popFragmentStack()

                val stack = backStack.get(lastAction.on).apply {
                    pop()
                }

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

        actionStack.push(DefaultTabAction(tab = currentTab))
    }

    private fun refreshCurrentTab() {
        val fragment =
            if (backStack.containsKey(currentTab) && backStack.get(currentTab).isNotEmpty()) {
                val stack = backStack.get(currentTab)

                val root = stack.last()

                backStack.push(MultipleStackResult(key = currentTab, value = mutableStackOf(root)))

                handler.showFragmentStack(listOf(root))

                root
            } else {
                createAndAddRootFragmentForTab(tab = currentTab)
            }

        listeners.onRefreshTab(tab = currentTab, fragment = fragment)
    }

    private fun switchToNewTab(tab: T) {
        Log.w("STACK", "Navigator: switchToNewTab: tab = $tab; currentTab = $currentTab")

        if (backStack.containsKey(tab) && backStack.get(tab).isNotEmpty()) {
            Log.w("STACK", "Navigator: switchToNewTab: contains tab: tab = $tab")

            val stack = backStack.get(tab)

            Log.w("STACK", "Navigator: switchToNewTab: contains tab: stack = $stack")

            handler.showFragmentStack(stack)
        } else {
            Log.w("STACK", "Navigator: switchToNewTab: does not contain tab: tab = $tab")

            createAndAddRootFragmentForTab(tab = tab)
        }

        actionStack.push(SwitchTabAction(from = currentTab, to = tab))

        listeners.onTabSwitched(from = currentTab, to = tab)

        currentTab = tab
    }

    private fun createAndAddRootFragmentForTab(tab: T): B {
        Log.w("STACK", "Navigator: createAndAddRootFragmentForTab: tab = $tab")

        val rootFragment = factory.createRootFragment(tab)

        val stack = mutableStackOf(rootFragment)

        handler.showFragmentStack(stack)

        backStack.push(MultipleStackResult(key = tab, value = stack))

        Log.w(
            "STACK",
            "Navigator: createAndAddRootFragmentForTab: tab = $tab; fragment = $rootFragment"
        )

        return rootFragment
    }
}