package com.chrynan.chat.navigation.core.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chrynan.chat.R
import com.chrynan.chat.navigation.core.BaseTabStackNavigator
import com.chrynan.chat.navigation.core.FragmentTransactionHandler
import com.chrynan.chat.navigation.core.Tab
import com.chrynan.chat.navigation.core.TabStackFactory

open class BaseTabStackNavigatorViewModelFactory<Tb : Tab, B : Fragment>(
    private val factory: TabStackFactory<Tb, B>,
    private val manager: FragmentManager,
    private val containerId: Int = R.id.fragmentContainer
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BaseTabStackNavigatorViewModel::class.java) { "${this::class.java.name} can only create ${BaseTabStackNavigatorViewModel::class.java.name} classes." }

        val navigator = BaseTabStackNavigator(
            factory = factory,
            handler = FragmentTransactionHandler(
                manager = manager,
                containerId = containerId
            )
        )

        return BaseTabStackNavigatorViewModel(navigator = navigator) as T
    }
}