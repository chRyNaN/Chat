package com.chrynan.chat.navigation.core

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface TabStackNavigator<T : Tab, B : Fragment> {

    val currentTab: T

    val activity: FragmentActivity

    val listeners: MutableList<TabStackListener<T, B>>

    fun selectTab(tab: T)

    fun goToFragment(fragment: B)

    fun goBack(): Boolean

    fun showDialog(fragment: DialogFragment)

    fun reset()
}