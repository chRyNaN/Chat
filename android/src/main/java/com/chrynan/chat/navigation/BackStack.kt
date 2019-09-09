package com.chrynan.chat.navigation

import com.chrynan.chat.ui.fragment.BaseFragment

class BackStack<T : Tab> {

    private val multipleStack = mutableMapOf<T, MutableList<BaseFragment>>()

    val tabCount: Int
        get() = multipleStack.size

    fun stackCountForTab(tab: T) = stackForTabOrEmpty(tab).size

    fun containsTab(tab: T) = multipleStack.containsKey(tab)

    fun isTabStackEmpty(tab: T) = stackForTabOrEmpty(tab).isEmpty()

    fun stackForTabOrNull(tab: T): List<BaseFragment>? = multipleStack[tab]

    fun stackForTabOrEmpty(tab: T): List<BaseFragment> = multipleStack[tab] ?: emptyList()

    fun topFragmentForTab(tab: T): BaseFragment? = multipleStack[tab]?.firstOrNull()

    fun addTabStack(tab: T, stack: List<BaseFragment> = emptyList()) {
        multipleStack[tab] = stack.toMutableList()
    }

    fun removeTabStack(tab: T): List<BaseFragment>? = multipleStack.remove(tab)

    fun popFragmentForTab(tab: T): BaseFragment? {
        val stack = multipleStack[tab]

        if (stack != null && stack.isNotEmpty()) {
            return stack.removeAt(stack.size - 1)
        }

        return null
    }

    fun pushFragmentForTab(fragment: BaseFragment, tab: T) {
        val stack = multipleStack[tab]

        if (stack != null) {
            stack.add(fragment)
            multipleStack[tab] = stack
        }
    }
}