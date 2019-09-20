package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun <T : Tab> List<TabStackListener<T>>.onTabSwitched(from: T, to: T) =
    forEach { it.onTabSwitched(from = from, to = to) }

fun <T : Tab> List<TabStackListener<T>>.onRefreshTab(tab: T, fragment: Fragment) =
    forEach { it.onRefreshTab(tab = tab, fragment = fragment) }

fun FragmentManager.findFragmentByInfo(info: FragmentInfo): Fragment? =
    findFragmentByTag(info.asFragmentTag())

fun FragmentManager.getBackStackIndexByFragmentName(name: String): Int {
    for (i in 0 until backStackEntryCount) {
        val entry = getBackStackEntryAt(i)
        if (entry.name == name) return i
    }

    return -1
}

fun FragmentManager.getBackStackEntriesFromIndex(index: Int): List<FragmentManager.BackStackEntry> {
    if (index >= backStackEntryCount) return emptyList()
    if (index < 0) return emptyList()

    val entries = mutableListOf<FragmentManager.BackStackEntry>()

    for (i in index until backStackEntryCount) {
        entries.add(getBackStackEntryAt(i))
    }

    return entries
}

fun FragmentManager.getFragmentsInBackStackFromIndex(index: Int): List<Fragment> {
    if (index >= backStackEntryCount) return emptyList()
    if (index < 0) return emptyList()

    val entries = getBackStackEntriesFromIndex(index)

    val fragments = mutableListOf<Fragment>()

    for (entry in entries) {
        // We are storing the name and tag as the same thing
        val fragment = findFragmentByTag(entry.name)

        if (fragment != null) {
            fragments.add(fragment)
        }
    }

    return fragments
}