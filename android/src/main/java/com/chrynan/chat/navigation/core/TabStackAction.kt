package com.chrynan.chat.navigation.core

import androidx.fragment.app.Fragment

sealed class TabStackAction<T : Tab>

data class FragmentPushAction<T : Tab>(
    val on: T,
    val fragment: Fragment
) : TabStackAction<T>()

data class SwitchTabAction<T : Tab>(
    val from: T,
    val to: T
) : TabStackAction<T>()

data class DefaultTabAction<T : Tab>(val tab: T) : TabStackAction<T>()