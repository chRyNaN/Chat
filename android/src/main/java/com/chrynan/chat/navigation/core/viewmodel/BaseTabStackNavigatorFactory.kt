package com.chrynan.chat.navigation.core.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.chrynan.chat.navigation.core.*

class BaseTabStackNavigatorFactory<T : Tab, B : Fragment> : TabStackNavigatorFactory<T, B> {

    /**
     * Calling this will either create a new instance or return an existing instance with some updated
     * values.
     */
    @Suppress("UNCHECKED_CAST")
    override fun getInstanceWith(
        activity: FragmentActivity,
        containerId: Int,
        factory: TabStackFactory<T, B>
    ): BaseTabStackNavigator<T, B> {
        val viewModelFactory = BaseTabStackNavigatorViewModelFactory(
            factory = factory,
            manager = activity.supportFragmentManager,
            containerId = containerId
        )

        val navigator =
            ViewModelProviders.of(activity, viewModelFactory)
                .get(BaseTabStackNavigator::class.java)
                .apply {
                    this.activity = activity
                }

        return navigator as BaseTabStackNavigator<T, B>
    }
}

fun <T : Tab, B : Fragment> getTabStackNavigatorWith(
    activity: FragmentActivity,
    containerId: Int,
    factory: TabStackFactory<T, B>
): TabStackNavigator<T, B> = BaseTabStackNavigatorFactory<T, B>().getInstanceWith(
    activity = activity,
    containerId = containerId,
    factory = factory
)