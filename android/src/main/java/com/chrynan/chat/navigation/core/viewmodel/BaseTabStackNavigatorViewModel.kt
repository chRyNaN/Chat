package com.chrynan.chat.navigation.core.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.chrynan.chat.navigation.core.BaseTabStackNavigator
import com.chrynan.chat.navigation.core.Tab

data class BaseTabStackNavigatorViewModel<T : Tab, B : Fragment>(
    override val navigator: BaseTabStackNavigator<T, B>
) : ViewModel(),
    TabStackNavigatorViewModel<T, B>