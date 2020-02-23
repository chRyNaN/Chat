package com.chrynan.chat.feature.conversation.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.utils.ActivityContext
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class MessageReactionListModule {

    @Module
    companion object {

        const val NAME_LAYOUT_MANAGER = "MessageReactionListLayoutManager"

        @Provides
        @JvmStatic
        @FragmentScope
        @Named(NAME_LAYOUT_MANAGER)
        fun provideLayoutManager(context: ActivityContext) =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}