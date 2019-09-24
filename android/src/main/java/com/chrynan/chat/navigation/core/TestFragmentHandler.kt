package com.chrynan.chat.navigation.core

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

internal class TestFragmentHandler(
    private val fm: FragmentManager,
    @IdRes private val container: Int
) {

    fun removeAllAndAdd(
        remove: List<FragmentInfo>,
        add: Fragment, addTag: FragmentInfo,
        runnable: () -> Unit
    ) {
        val transaction = fm.beginTransaction()
        for (removeTag in remove) {
            val removeFragment = fm.findFragmentByTag(removeTag.toString())
            if (removeFragment != null) {
                transaction.remove(removeFragment)
            }
        }
        transaction.add(container, add, addTag.toString())
            .detachOtherFragments(add)
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commitNow()
    }

    fun removeAllAndShow(
        remove: List<FragmentInfo>,
        show: FragmentInfo,
        runnable: () -> Unit
    ) {
        val transaction = fm.beginTransaction()
        for (removeTag in remove) {
            val removeFragment = fm.findFragmentByTag(removeTag.toString())
            if (removeFragment != null) {
                transaction.remove(removeFragment)
            }
        }
        val fragment = fm.findFragmentByTag(show.toString())!!
        transaction.showOrAttach(fragment)
            .detachOtherFragments(fragment)
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commitNow()
    }

    fun showAndRemoveFragment(
        showTag: FragmentInfo,
        removeTag: FragmentInfo,
        runnable: () -> Unit
    ) {
        val showFragment = fm.findFragmentByTag(showTag.toString())!!
        val removeFragment = fm.findFragmentByTag(removeTag.toString())!!
        fm.beginTransaction()
            .remove(removeFragment)
            .detachOtherFragments(showFragment)
            .showOrAttach(showFragment)
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commit()
    }

    fun showFragment(
        tag: FragmentInfo,
        runnable: () -> Unit
    ) {
        val fragment = fm.findFragmentByTag(tag.toString())!!
        fm.beginTransaction()
            .showOrAttach(fragment)
            .detachOtherFragments(fragment)
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commitNow()
    }

    fun addAndShowFragment(
        fragment: Fragment,
        tag: FragmentInfo,
        runnable: () -> Unit
    ) {
        fm.beginTransaction()
            .add(container, fragment, tag.toString())
            .detachOtherFragments(fragment)
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commitNow()
    }

    fun clear(runnable: () -> Unit) {
        fm.fragments
            .fold(fm.beginTransaction()) { transaction, fragment ->
                transaction.remove(fragment)
            }
            .runOnCommit(runnable)
            .setReorderingAllowed(true)
            .commitNow()
    }

    private fun FragmentTransaction.showOrAttach(fragment: Fragment): FragmentTransaction {
        return if (true) {
            attach(fragment)
        } else {
            show(fragment)
        }
    }

    private fun FragmentTransaction.detachOtherFragments(keep: Fragment): FragmentTransaction {
        return fm.fragments
            .filter { it != keep }
            .fold(this) { transaction, fragment ->
                if (true) {
                    transaction.detach(fragment)
                } else {
                    transaction.hide(fragment)
                }
            }
    }
}