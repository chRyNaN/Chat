package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chrynan.chat.R

open class BaseTabStackNavigatorFactory<Tb : Tab, B : Fragment>(
    private val factory: TabStackFactory<Tb, B>,
    private val manager: FragmentManager,
    private val containerId: Int = R.id.fragmentContainer
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == BaseTabStackNavigator::class.java) { "${this::class.java.name} can only create ${BaseTabStackNavigatorFactory::class.java.name} classes." }

        return BaseTabStackNavigator(
            factory = factory,
            handler = FragmentTransactionHandler(
                manager = manager,
                containerId = containerId
            )
        ) as T
    }
}