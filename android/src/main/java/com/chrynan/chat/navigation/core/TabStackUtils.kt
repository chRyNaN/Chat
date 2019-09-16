package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.collections.Stack

fun <T : Tab> List<TabStackListener<T>>.onTabSwitched(from: T, to: T) =
    forEach { it.onTabSwitched(from = from, to = to) }

fun <T : Tab> List<TabStackListener<T>>.onRefreshTab(tab: T, fragment: Fragment) =
    forEach { it.onRefreshTab(tab = tab, fragment = fragment) }

fun FragmentTransactionHandler.removeFragmentsExceptForBottomOfStack(stack: Stack<FragmentInfo>): Fragment {
    val fragmentsToRemove = mutableListOf<FragmentInfo>()
    var fragmentToShow: FragmentInfo? = null

    stack.forEachIndexed { index, fragmentInfo ->
        if (index == stack.size - 1) {
            fragmentToShow = fragmentInfo
        } else {
            fragmentsToRemove.add(fragmentInfo)
        }
    }

    return removeFragmentsThenAddFragment(
        fragmentsToRemove = fragmentsToRemove,
        fragmentToShow = fragmentToShow!!
    )
}

fun FragmentManager.findFragmentByInfo(info: FragmentInfo): Fragment? =
    findFragmentByTag(info.asFragmentTag())