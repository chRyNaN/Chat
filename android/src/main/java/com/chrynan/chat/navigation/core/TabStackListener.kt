package com.chrynan.chat.navigation.core

interface TabStackListener<T : Tab> {

    fun onTabSwitched(from: T, to: T)
}