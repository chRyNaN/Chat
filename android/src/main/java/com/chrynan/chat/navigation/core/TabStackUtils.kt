package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.navigation.core.viewmodel.getTabStackNavigatorWith
import com.google.android.material.bottomnavigation.BottomNavigationView

fun <T : Tab, B : Fragment> List<TabStackListener<T, B>>.onTabSwitched(from: T, to: T) =
    forEach { it.onTabSwitched(from = from, to = to) }

fun <T : Tab, B : Fragment> List<TabStackListener<T, B>>.onRefreshTab(tab: T, fragment: B) =
    forEach { it.onRefreshTab(tab = tab, fragment = fragment) }

fun <E> MutableList<E>.push(element: E) = add(element)

fun <E> MutableList<E>.popOrNull() =
    try {
        removeAt(size - 1)
    } catch (e: Exception) {
        null
    }

fun <E> MutableList<E>.peek() = last()

fun FragmentManager.clearEntireBackStack() {
    while (backStackEntryCount > 0) {
        popBackStackImmediate()
    }
}

fun <T : Tab, B : Fragment> BottomNavigationView.navigatorWith(
    activity: FragmentActivity,
    containerId: Int,
    factory: TabStackFactory<T, B>,
    onTabSwitched: ((from: T, to: T) -> Unit)? = null,
    onRefreshTab: ((tab: T, fragment: B) -> Unit)? = null
): TabStackNavigator<T, B> {
    val navigator = getTabStackNavigatorWith(
        activity = activity,
        containerId = containerId,
        factory = factory
    )

    var tabSwitchedByListener = false

    navigator.listeners.add(object : TabStackListener<T, B> {

        override fun onTabSwitched(from: T, to: T) {
            tabSwitchedByListener = true
            selectedItemId = to.id
            onTabSwitched?.invoke(from, to)
        }

        override fun onRefreshTab(tab: T, fragment: B) {
            onRefreshTab?.invoke(tab, fragment)
        }
    })

    setOnNavigationItemSelectedListener { menuItem ->
        if (!tabSwitchedByListener) {
            val tab = factory.rootTabs.firstOrNull { it.id == menuItem.itemId }

            tab?.let {
                navigator.selectTab(tab = it)
                true
            } ?: false
        } else {
            tabSwitchedByListener = false
            false
        }
    }

    setOnNavigationItemReselectedListener { menuItem ->
        if (!tabSwitchedByListener) {
            val tab = factory.rootTabs.firstOrNull { it.id == menuItem.itemId }

            tab?.let {
                navigator.selectTab(tab = it)
            }
        } else {
            tabSwitchedByListener = false
        }
    }

    selectedItemId = factory.defaultTab.id

    return navigator
}