package com.chrynan.chat.navigation

interface FragmentTabSwitchedListener<T : Tab> {

    fun onTabSwitched(tab: T)
}