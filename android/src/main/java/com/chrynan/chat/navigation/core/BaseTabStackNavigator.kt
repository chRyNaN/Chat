package com.chrynan.chat.navigation.core

import android.util.Log
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
        Log.w("STACK", "Navigator: switchTab: tab = $tab")

        if (tab == currentTab) {
            refreshCurrentTab()
        } else {
            switchToNewTab(tab = tab)
        }
    }

    override fun goToFragment(fragment: B) {
        Log.w("STACK", "Navigator: goToFragment: fragment = $fragment")

        val info = handler.addFragmentToCurrentTab(fragment)

        val stack = backStack.get(currentTab)
        stack.push(info)

        backStack.push(MultipleStackResult(key = currentTab, value = stack))
        actionStack.pushLast(FragmentPushAction(on = currentTab, info = info))
    }

    override fun goBack(): Boolean {
        Log.w("STACK", "Navigator: goBack")

        when (val lastAction = actionStack.getLastOrNull() ?: return false) {
            is DefaultTabAction -> {
                // We are on the default root fragment, so return false because we can't go back further
                return false
            }
            is SwitchTabAction -> {
                // Remove the current back stack of fragments, then add the previous tabs back stack
                //val fragmentsToRemove = backStack.get(lastAction.to)
                //val fragmentsToShow = backStack.get(lastAction.from)

                //handler.removeFragmentsThenAddFragments(
                //  fragmentsToRemove = fragmentsToRemove,
                //  fragmentsToShow = fragmentsToShow
                //)


                return true
            }
            is FragmentPushAction -> {
                // Remove the previously added fragment
                //handler.popFragmentBackStack()

                //val stack = backStack.get(lastAction.on).toMutableStack()
                //stack.pop()

                //backStack.push(MultipleStackResult(key = lastAction.on, value = stack))

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
        Log.w("STACK", "Navigator: setupDefault")
        createAndAddRootFragmentForTab(tab = currentTab)
        actionStack.pushLast(DefaultTabAction(tab = currentTab))
    }

    private fun refreshCurrentTab() {
        Log.w("STACK", "Navigator: refreshCurrentTab: currentTab = $currentTab")

        //val fragment =
        if (backStack.containsKey(currentTab) && backStack.get(currentTab).isNotEmpty()) {
            val stack = backStack.get(currentTab)

            val root = stack.last()

            val fragmentsToRemove = stack.filter { it != root }

            backStack.push(MultipleStackResult(key = currentTab, value = mutableStackOf(root)))

            //handler.removeFragmentsThenAddFragment(
            //   fragmentsToRemove = fragmentsToRemove,
            //   fragmentToShow = root
            // )

            handler.goToRootTabFragment(listOf(root))
        } else {
            //createAndAddRootFragmentForTab(tab = currentTab)
            switchToNewTab(currentTab)
        }

        //listeners.onRefreshTab(tab = currentTab, fragment = fragment)
    }

    private fun switchToNewTab(tab: T) {
        if (backStack.containsKey(tab) && backStack.get(tab).isNotEmpty()) {
            Log.w("STACK", "Navigator: switchToNewTab: contains tab: tab = $tab")

            handler.goToExistingTab(backStack.get(tab).toList())
        } else {
            Log.w("STACK", "Navigator: switchToNewTab: does not contain tab: tab = $tab")

            createAndAddRootFragmentForTab(tab = tab)
        }

        actionStack.pushLast(SwitchTabAction(from = currentTab, to = currentTab))

        listeners.onTabSwitched(from = currentTab, to = tab)

        currentTab = tab
    }

    private fun createAndAddRootFragmentForTab(tab: T): Fragment {
        Log.w("STACK", "Navigator: createAndAddRootFragmentForTab: tab = $tab")

        val rootFragment = factory.createRootFragment(tab)
        val infoList = handler.goToNewTab(listOf(rootFragment))
        val stack = mutableStackOf(*infoList.toTypedArray())

        backStack.push(MultipleStackResult(key = tab, value = stack))

        Log.w(
            "STACK",
            "Navigator: createAndAddRootFragmentForTab: tab = $tab; fragment = $rootFragment"
        )

        return rootFragment
    }
}