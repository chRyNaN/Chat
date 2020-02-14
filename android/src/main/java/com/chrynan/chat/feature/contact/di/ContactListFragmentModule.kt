package com.chrynan.chat.feature.contact.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.adapter.BaseAdapterItemHandler
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.contact.adapter.ContactAdapter
import com.chrynan.chat.feature.contact.view.ContactListView
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.ContactListFragment
import com.chrynan.chat.utils.ActivityContext
import dagger.Binds
import dagger.Provides

@Module
abstract class ContactListFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideBaseManagerAdapter(
            layoutManager: LinearLayoutManager,
            contactAdapter: ContactAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(contactAdapter),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context)
    }

    @Binds
    @FragmentScope
    abstract fun bindContactListView(fragment: ContactListFragment): ContactListView

    @Binds
    @FragmentScope
    abstract fun bindContactSelectedListener(fragment: ContactListFragment): ContactAdapter.ContactSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindAdapterItemHandler(handler: BaseAdapterItemHandler<AdapterItem>): AdapterItemHandler<AdapterItem>
}