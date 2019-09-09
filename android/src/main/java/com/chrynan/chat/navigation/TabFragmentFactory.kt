package com.chrynan.chat.navigation

import com.chrynan.chat.ui.fragment.BaseFragment

interface TabFragmentFactory<T : Tab> {

    val defaultTab: T

    val rootTabs: List<T>

    fun create(tab: T): BaseFragment
}