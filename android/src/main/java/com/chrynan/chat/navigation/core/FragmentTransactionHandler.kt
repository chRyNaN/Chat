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

        val fragment = manager.findFragmentByTag(info.asFragmentTag())!!

        transaction.show(fragment)

        transaction.commitNow()

        return fragment
    }

    fun removeFragments(
        fragmentsToRemove: Iterable<FragmentInfo>,
        fragmentToShow: FragmentInfo
    ): Fragment {
        val transaction = manager.beginTransaction()

        // Remove
        fragmentsToRemove
            .forEach {
                val fragment = manager.findFragmentByTag(it.asFragmentTag())

                if (fragment != null) transaction.remove(fragment)
            }

        // Add
        val fragment = manager.findFragmentByTag(fragmentToShow.asFragmentTag())!!

        transaction.replace(containerId, fragment, fragmentToShow.asFragmentTag())

        transaction.commitNow()

        return fragment
    }
}