package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.R

class FragmentTransactionHandler(
    private val manager: FragmentManager,
    private val containerId: Int = R.id.fragmentContainer
) {

    fun addFragment(fragment: Fragment): FragmentInfo {
        val transaction = manager.beginTransaction()

        val info = FragmentInfo.fromFragment(fragment)

        transaction.replace(containerId, fragment, info.asFragmentTag())

        transaction.commitNow()

        return info
    }

    fun showExistingFragment(info: FragmentInfo): Fragment {
        val transaction = manager.beginTransaction()

        val fragment = manager.findFragmentByInfo(info)!!

        transaction.show(fragment)

        transaction.commitNow()

        return fragment
    }

    fun removeFragmentsThenAddFragment(
        fragmentsToRemove: Iterable<FragmentInfo>,
        fragmentToShow: FragmentInfo
    ): Fragment {
        val transaction = manager.beginTransaction()

        // Remove
        fragmentsToRemove
            .forEach {
                val fragment = manager.findFragmentByInfo(it)

                if (fragment != null) transaction.remove(fragment)
            }

        // Add
        val fragment = manager.findFragmentByInfo(fragmentToShow)!!

        transaction.replace(containerId, fragment, fragmentToShow.asFragmentTag())

        transaction.commitNow()

        return fragment
    }

    fun removeFragmentsThenAddFragments(
        fragmentsToRemove: Iterable<FragmentInfo>,
        fragmentsToShow: Iterable<FragmentInfo>,
        topFragment: Fragment
    ): FragmentInfo {
        val transaction = manager.beginTransaction()

        // Remove
        fragmentsToRemove
            .forEach {
                val fragment = manager.findFragmentByInfo(it)

                if (fragment != null) transaction.remove(fragment)
            }

        // Add
        fragmentsToShow.forEach {
            val fragment = manager.findFragmentByInfo(it)!!

            transaction.replace(containerId, fragment, it.asFragmentTag())
        }

        // Add top fragment
        val info = FragmentInfo.fromFragment(topFragment)

        transaction.replace(containerId, topFragment, info.asFragmentTag())

        transaction.commitNow()

        return info
    }

    fun removeFragmentsThenAddFragments(
        fragmentsToRemove: Iterable<FragmentInfo>,
        fragmentsToShow: Iterable<FragmentInfo>
    ) {
        val transaction = manager.beginTransaction()

        // Remove
        fragmentsToRemove
            .forEach {
                val fragment = manager.findFragmentByInfo(it)

                if (fragment != null) transaction.remove(fragment)
            }

        // Add
        fragmentsToShow.forEach {
            val fragment = manager.findFragmentByInfo(it)!!

            transaction.replace(containerId, fragment, it.asFragmentTag())
        }

        transaction.commitNow()
    }

    fun popFragmentBackStack() = manager.popBackStack()

    fun clear() {
        val transaction = manager.beginTransaction()

        for (fragment in manager.fragments) {
            transaction.remove(fragment)
        }

        transaction.commitNow()
    }
}