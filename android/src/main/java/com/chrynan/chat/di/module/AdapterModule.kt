package com.chrynan.chat.di.module

import com.chrynan.aaaah.*
import com.chrynan.chat.adapter.AdapterItem
import dagger.Provides

@Module
class AdapterModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideDiffCalculator() = DiffUtilCalculator<AdapterItem>()

        @Provides
        @JvmStatic
        fun provideDiffProcessor(calculator: DiffUtilCalculator<AdapterItem>): DiffProcessor<AdapterItem> =
            AndroidDiffProcessor(calculator)

        @Provides
        @JvmStatic
        fun provideDiffDispatcher(listener: ItemListUpdater<AdapterItem>): DiffDispatcher<AdapterItem> =
            AndroidDiffDispatcher(listener)
    }
}