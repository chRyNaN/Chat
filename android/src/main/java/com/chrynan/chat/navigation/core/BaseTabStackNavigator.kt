package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.chrynan.chat.R
import com.chrynan.chat.collections.*

open class BaseTabStackNavigator<T : Tab, B : Fragment> internal constructor(
    private val factory: TabStackFactory<T, B>,
    private val handler: FragmentTransactionHandler
) : ViewModel(),
    TabStackNavigator<T, B> {

    companion object {

        /**
         * Calling this will either create a new instance or return an existing instance with some updated
         * values.
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : Tab, B : Fragment> getInstanceWith(
            factory: TabStackFactory<T, B>,
            manager: FragmentManager,
            containerId: Int = R.id.fragmentContainer,
            activity: FragmentActivity,
            viewModelFactory: BaseTabStackNavigatorFactory<T, B> = BaseTabStackNavigatorFactory(
                factory = factory,
                manager = manager,
                containerId = containerId
            )
        ): BaseTabStackNavigator<T, B> {
            val navigator =
                ViewModelProviders.of(activity, viewModelFactory)
                    .get(BaseTabStackNavigator::class.java)
                    .apply {
                        boundToActivity = activity
                    }

            return navigator as BaseTabStackNavigator<T, B>
        }
    }

    override var currentTab: T = factory.defaultTab
        protected set

    override lateinit var boundToActivity: FragmentActivity
        internal set

    override var listener: TabStackListener<T>? = null

    private val backStack = MultipleStack<T, FragmentInfo>()
    private val actionStack = mutableStackOf<TabStackAction<T>>()

    private fun setupWith() {
        // TODO might need an Activity here for persisting everything. Android Architecture ViewModel object?
        for (tab in factory.rootTabs) {
            val fragment = factory.createRootFragment(tab)

            backStack.push(
                MultipleStackResult(
                    key = tab,
                    value = stackOf(FragmentInfo.fromFragment(fragment))
                )
            )
        }
    }

    override fun switchTab(tab: T) {
        actionStack.push(SwitchTabAction(from = currentTab, to = tab))

        // TODO check this logic
        val stack = backStack.get(tab)
        val info = stack.peek()
        handler.showExistingFragment(info)

        listener?.onTabSwitched(from = currentTab, to = tab)
        currentTab = tab
    }

    override fun goToFragment(fragment: B) {
        val info = handler.addFragment(fragment)

        val currentStack = backStack.get(currentTab)
        val newStack = currentStack + info

        backStack.push(MultipleStackResult(key = currentTab, value = newStack))
        actionStack.push(FragmentPushAction(on = currentTab))
    }

    override fun goBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshRootFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}