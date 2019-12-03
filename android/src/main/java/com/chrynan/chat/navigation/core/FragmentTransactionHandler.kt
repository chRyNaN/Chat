package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.R

class FragmentTransactionHandler(
    val manager: FragmentManager,
    val containerId: Int = R.id.fragmentContainer
) {

    fun clear() = manager.clearEntireBackStack()

    fun popFragmentStack() {
        manager.popBackStack()
    }

    fun addFragmentToStack(fragment: Fragment) {
        val transaction = manager.beginTransaction()

        transaction.replace(containerId, fragment)

        transaction.addToBackStack(null)

        transaction.commit()

        manager.executePendingTransactions()
    }

    fun showFragmentStack(fragments: Iterable<Fragment>) {
        manager.clearEntireBackStack()

        val transaction = manager.beginTransaction()

        for (fragment in fragments) {
            transaction.setReorderingAllowed(true)

            transaction.replace(containerId, fragment)

            transaction.addToBackStack(null)
        }

        transaction.commit()

        manager.executePendingTransactions()
    }
}