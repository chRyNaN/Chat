package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface TabStackNavigator<T : Tab, B : Fragment> {

    val currentTab: T

    val boundToActivity: FragmentActivity

    var listener: TabStackListener<T>?

    fun switchTab(tab: T)

    fun goToFragment(fragment: B)

    fun goBack()

    fun refreshRootFragment()
}