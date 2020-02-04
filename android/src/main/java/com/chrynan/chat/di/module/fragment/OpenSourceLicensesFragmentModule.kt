package com.chrynan.chat.di.module.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.adapter.ProjectDependencyAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.OpenSourceLicensesFragment
import com.chrynan.chat.utils.ActivityContext
import com.chrynan.chat.view.OpenSourceLicensesView
import dagger.Binds
import dagger.Provides

@Module
abstract class OpenSourceLicensesFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideBaseManagerAdapter(
            layoutManager: LinearLayoutManager,
            dependencyAdapter: ProjectDependencyAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(
                    dependencyAdapter
                ),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context)
    }

    @Binds
    @FragmentScope
    abstract fun bindConversationView(fragment: OpenSourceLicensesFragment): OpenSourceLicensesView

    @Binds
    @FragmentScope
    abstract fun bindThreadListener(fragment: OpenSourceLicensesFragment): ProjectDependencyAdapter.ProjectDependencySelectedListener

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindAdapterItemHandler(handler: BaseAdapterItemHandler<AdapterItem>): AdapterItemHandler<AdapterItem>
}