package com.chrynan.chat.utils

import android.app.Activity
import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.getDialogParentListenerOrThrow(): T =
    getDialogParentListenerOrNull<T>()
        ?: throw RuntimeException("Dialog parent, ${this.parentFragment?.javaClass?.name}, of ${this::class.simpleName} must implement listener ${T::class.simpleName}")

inline fun <reified T> Fragment.getDialogParentListenerOrNull(): T? {
    val parentFragment: Fragment? = this.parentFragment

    if (parentFragment != null && parentFragment is T) {
        return parentFragment
    } else {
        val activity: Activity? = this.activity

        if (activity != null && activity is T) {
            return activity
        }
    }

    return null
}