package com.chrynan.chat.navigation.core

sealed class TabStackAction<T : Tab>

data class FragmentPushAction<T : Tab>(val on: T) : TabStackAction<T>()

data class SwitchTabAction<T : Tab>(
    val from: T,
    val to: T
) : TabStackAction<T>()