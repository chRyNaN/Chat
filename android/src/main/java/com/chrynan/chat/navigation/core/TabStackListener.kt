package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment

interface TabStackListener<T : Tab, B : Fragment> {

    fun onTabSwitched(from: T, to: T)

    fun onRefreshTab(tab: T, fragment: B)
}