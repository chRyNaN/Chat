package com.chrynan.chat.navigation.core

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chrynan.chat.R

class FragmentTransactionHandler(
    private val manager: FragmentManager,
    private val containerId: Int = R.id.fragmentContainer
) {

    fun clear() {
        Log.w("STACK", "Transaction: clear")

        val transaction = manager.beginTransaction()

        transaction.setReorderingAllowed(true)

        for (fragment in manager.fragments) {
            transaction.remove(fragment)
        }

        transaction.commitNow()
    }


    fun addFragmentToCurrentTab(fragment: Fragment): FragmentInfo {
        Log.w("STACK", "Transaction: addFragmentToCurrentTab: fragment = $fragment")

        val transaction = manager.beginTransaction()

        transaction.setReorderingAllowed(true)

        val info = FragmentInfo.fromFragment(fragment)

        Log.w("STACK", "Transaction: addFragmentToCurrentTab: fragment = $fragment; info = $info")

        transaction.replace(containerId, fragment, info.asFragmentTag())

        transaction.addToBackStack(info.asFragmentTag())

        transaction.commit()

        return info
    }

    fun goBackOnCurrentTab() {
        Log.w("STACK", "Transaction: goBackOnCurrentTab")

        manager.popBackStackImmediate()
    }

    fun goToRootTabFragment(tabFragments: List<FragmentInfo>) {
        Log.w("STACK", "goToRootTabFragment: tabFragments = $tabFragments")

        if (tabFragments.isNotEmpty()) {
            val first = tabFragments.first()
            val last = tabFragments.last()

            val index = manager.getBackStackIndexByFragmentName(first.asFragmentTag())

            val backStackFragmentsFromIndex = manager.getFragmentsInBackStackFromIndex(index)
            val bottomOfStackFragments = mutableListOf<Fragment>()
            val topOfStackFragments = mutableListOf<Fragment>()
            var pastTopFragments = false

            for (fragment in backStackFragmentsFromIndex) {
                when {
                    pastTopFragments -> bottomOfStackFragments.add(fragment)
                    last.asFragmentTag() == fragment.tag -> {
                        pastTopFragments = true
                    }
                    first.asFragmentTag() == fragment.tag -> topOfStackFragments.add(fragment)
                    else -> {
                    }
                }
            }

            val transaction = manager.beginTransaction()

            manager.popBackStackImmediate(
                first.asFragmentTag(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            transaction.setReorderingAllowed(true)

            (bottomOfStackFragments + topOfStackFragments).forEach {
                transaction.replace(containerId, it, it.tag)
                transaction.addToBackStack(it.tag)
            }

            transaction.commit()
        }
    }

    fun goToNewTab(tabFragments: List<Fragment>): List<FragmentInfo> {
        Log.w("STACK", "Transaction: goToNewTab: tabFragments = $tabFragments")

        val infoList = mutableListOf<FragmentInfo>()

        if (tabFragments.isNotEmpty()) {
            val transaction = manager.beginTransaction()

            transaction.setReorderingAllowed(true)

            tabFragments.forEach {
                val info = FragmentInfo.fromFragment(it)
                transaction.replace(containerId, it, info.asFragmentTag())
                transaction.addToBackStack(info.asFragmentTag())
                infoList.add(info)
            }

            transaction.commit()
        }

        Log.w("STACK", "Transaction: goToNewTab: infoList = $infoList")

        return infoList
    }

    fun goToExistingTab(tabFragments: List<FragmentInfo>) {
        Log.w("STACK", "Transaction: goToExistingTab: tabFragments = $tabFragments")

        if (tabFragments.isNotEmpty()) {
            val first = tabFragments.first()
            val last = tabFragments.last()

            val index = manager.getBackStackIndexByFragmentName(first.asFragmentTag())

            Log.w("STACK", "Transaction: goToExistingTab: allFragments = ${manager.fragments}")
            Log.w("STACK", "Transaction: goToExistingTab: index = $index")

            val backStackFragmentsFromIndex = manager.getFragmentsInBackStackFromIndex(index)
            val bottomOfStackFragments = mutableListOf<Fragment>()
            val topOfStackFragments = mutableListOf<Fragment>()
            var pastTopFragments = false

            Log.w(
                "STACK",
                "Transaction: goToExistingTab: backStackFragmentsFromIndex = $backStackFragmentsFromIndex"
            )

            for (fragment in backStackFragmentsFromIndex) {
                when {
                    pastTopFragments -> bottomOfStackFragments.add(fragment)
                    last.asFragmentTag() == fragment.tag -> {
                        pastTopFragments = true
                        topOfStackFragments.add(fragment)
                    }
                    else -> topOfStackFragments.add(fragment)
                }
            }

            Log.w("STACK", "Transaction: goToExistingTab: bottomOfStack = $bottomOfStackFragments")
            Log.w("STACK", "Transaction: goToExistingTab: topOfStack = $topOfStackFragments")

            val transaction = manager.beginTransaction()

            manager.popBackStackImmediate(
                first.asFragmentTag(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            transaction.setReorderingAllowed(true)

            (bottomOfStackFragments + topOfStackFragments).forEach {
                transaction.replace(containerId, it, it.tag)
                transaction.addToBackStack(it.tag)
            }

            transaction.commit()
        }
    }
}