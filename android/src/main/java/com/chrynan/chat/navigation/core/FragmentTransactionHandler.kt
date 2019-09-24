package com.chrynan.chat.navigation.core

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.R

class FragmentTransactionHandler(
    val manager: FragmentManager,
    val containerId: Int = R.id.fragmentContainer
) {

    fun clear() = manager.clearEntireBackStack()

    fun popFragmentStack() {
        Log.w("STACK", "Transaction: popFragmentStack: fragments = ${manager.fragments}")

        manager.popBackStack()
    }

    fun addFragmentToStack(fragment: Fragment) {
        Log.w("STACK", "Transaction: addFragmentToStack: fragment = $fragment")
        Log.w("STACK", "Transaction: addFragemntToStack: fragments = ${manager.fragments}")

        val transaction = manager.beginTransaction()

        transaction.replace(containerId, fragment)

        transaction.addToBackStack(null)

        transaction.commit()

        manager.executePendingTransactions()
    }

    fun showFragmentStack(fragments: Iterable<Fragment>) {
        Log.w("STACK", "Transaction: showFragmentStack: fragments = $fragments")
        Log.w(
            "STACK",
            "Transaction: showFragmentStack: before popBackStackImmediate(): manager fragments = ${manager.fragments}"
        )

        manager.clearEntireBackStack()

        Log.w(
            "STACK",
            "Transaction: showFragmentStack: after popBackStackImmediate(): manager fragments = ${manager.fragments}"
        )

        val transaction = manager.beginTransaction()

        for (fragment in fragments) {
            transaction.setReorderingAllowed(true)

            transaction.replace(containerId, fragment)

            transaction.addToBackStack(null)
        }

        transaction.commit()

        manager.executePendingTransactions()
    }

    private fun FragmentManager.clearEntireBackStack() {
        while (backStackEntryCount > 0) {
            popBackStackImmediate()
        }
    }
}