package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface TabStackNavigatorFactory<T : Tab, B : Fragment> {

    fun getInstanceWith(
        activity: FragmentActivity,
        containerId: Int,
        factory: TabStackFactory<T, B>
    ): BaseTabStackNavigator<T, B>
}