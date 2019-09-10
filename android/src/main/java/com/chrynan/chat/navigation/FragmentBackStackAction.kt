package com.chrynan.chat.navigation

sealed class FragmentBackStackAction<T : Tab>

class FragmentPushAction<T : Tab> : FragmentBackStackAction<T>()

data class SwitchTabAction<T : Tab>(
    val from: T,
    val to: T
) : FragmentBackStackAction<T>()