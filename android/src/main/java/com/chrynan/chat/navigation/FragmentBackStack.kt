package com.chrynan.chat.navigation

import com.chrynan.chat.collections.Stack
import com.chrynan.chat.collections.emptyStack
import com.chrynan.chat.ui.fragment.BaseFragment

class FragmentBackStack<T : Tab, B : BaseFragment> {

    private val multipleStack = LinkedHashMap<T, Stack<B>>()

    val tabCount: Int
        get() = multipleStack.size

    val currentTab: T?
        get() = multipleStack.keys.firstOrNull()

    fun stackCountForTab(tab: T) = stackForTabOrEmpty(tab).size

    fun containsTab(tab: T) = multipleStack.containsKey(tab)

    fun isTabStackEmpty(tab: T) = stackForTabOrEmpty(tab).isEmpty()

    fun stackForTabOrNull(tab: T): Stack<B>? = multipleStack[tab]

    fun stackForTabOrEmpty(tab: T): Stack<B> = multipleStack[tab] ?: emptyStack()

    fun topFragmentForTab(tab: T): B? = multipleStack[tab]?.firstOrNull()

    fun addTabStack(tab: T, stack: Stack<B> = emptyStack()) {
        // TODO
    }

    fun removeTabStack(tab: T): Stack<B>? = multipleStack.remove(tab)

    fun popFragmentForTab(tab: T): B? {
        // TODO

        return null
    }

    fun pushFragmentForTab(fragment: B, tab: T): Boolean {
        // TODO

        return true
    }

    fun peekFragment(): B? {
        val stack = multipleStack[currentTab]

        return stack?.firstOrNull()
    }

    fun popFragment(): B? {
        // TODO

        return null
    }

    fun pushFragment(fragment: B): Boolean {
        // TODO

        return true
    }
}