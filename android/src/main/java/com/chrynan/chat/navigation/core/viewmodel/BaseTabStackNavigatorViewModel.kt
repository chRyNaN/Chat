package com.chrynan.chat.navigation.core.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.chrynan.chat.navigation.core.Tab
import com.chrynan.chat.navigation.core.TabStackNavigator

data class BaseTabStackNavigatorViewModel<T : Tab, B : Fragment>(
    override val navigator: TabStackNavigator<T, B>
) : ViewModel(),
    TabStackNavigatorViewModel<T, B>