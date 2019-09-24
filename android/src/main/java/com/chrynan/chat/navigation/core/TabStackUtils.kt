package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment

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