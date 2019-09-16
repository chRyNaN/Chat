package com.chrynan.chat.navigation.core.viewmodel

import androidx.fragment.app.Fragment
import com.chrynan.chat.navigation.core.Tab
import com.chrynan.chat.navigation.core.TabStackNavigator

interface TabStackNavigatorViewModel<T : Tab, B : Fragment> {

    val navigator: TabStackNavigator<T, B>
}