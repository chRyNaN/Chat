package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment

interface TabStackFactory<T : Tab, B : Fragment> {

    val defaultTab: T

    val rootTabs: List<T>

    fun createRootFragment(tab: T): B
}